package DailyChallenges.Hard;

import DailyChallenges.Medium.Pair;

import java.util.*;

//Problem-2818
public class maximumScore {
    class Solution {
        public int maximumScore(List<Integer> nums, int k) {
            int n = nums.size();
            int maxNum = Collections.max(nums);
            int[] minPrimeFactors = sieveEratosthenes(maxNum + 1);
            int[] primeScores = getPrimeScores(nums, minPrimeFactors);
            int ans = 1;
            int[] left = new int[n];
            Arrays.fill(left, -1);
            int[] right = new int[n];
            Arrays.fill(right, n);
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = n - 1; i >= 0; --i) {
                while (!stack.isEmpty() && primeScores[stack.peek()] <= primeScores[i]) {
                    left[stack.pop()] = i;
                }
                stack.push(i);
            }
            stack.clear();

            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                    right[stack.pop()] = i;
                }
                stack.push(i);
            }

            Pair<Integer, Integer>[] numAndIndexes = new Pair[n];
            for (int i = 0; i < n; ++i) {
                numAndIndexes[i] = new Pair<>(nums.get(i), i);
            }
            Arrays.sort(numAndIndexes, (a, b) -> b.getKey().equals(a.getKey()) ? a.getValue() - b.getValue() : b.getKey() - a.getKey());

            for (Pair<Integer, Integer> numAndIndex : numAndIndexes) {
                int num = numAndIndex.getKey();
                int i = numAndIndex.getValue();
                long rangeCount = (long) (i - left[i]) * (right[i] - i);
                long actualCount = Math.min(rangeCount, k);
                k -= actualCount;
                ans = (int) ((1L * ans * modPow(num, actualCount)) % kMod);
                if (k == 0) break;
            }
            return ans;
        }

        private static final int kMod = 1_000_000_007;

        private long modPow(long x, long n) {
            long result = 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    result = (result * x) % kMod;
                }
                x = (x * x) % kMod;
                n /= 2;
            }
            return result;
        }

        private int[] sieveEratosthenes(int n) {
            int[] minPrimeFactors = new int[n + 1];
            for (int i = 2; i <= n; ++i) {
                minPrimeFactors[i] = i;
            }
            for (int i = 2; i * i <= n; ++i) {
                if (minPrimeFactors[i] == i) {
                    for (int j = i * i; j <= n; j += i) {
                        if (minPrimeFactors[j] == j) {
                            minPrimeFactors[j] = i;
                        }
                    }
                }
            }
            return minPrimeFactors;
        }

        private int[] getPrimeScores(List<Integer> nums, int[] minPrimeFactors) {
            int[] primeScores = new int[nums.size()];
            for (int i = 0; i < nums.size(); ++i) {
                primeScores[i] = getPrimeScore(nums.get(i), minPrimeFactors);
            }
            return primeScores;
        }

        private int getPrimeScore(int num, int[] minPrimeFactors) {
            Set<Integer> primeFactors = new HashSet<>();
            while (num > 1) {
                int divisor = minPrimeFactors[num];
                primeFactors.add(divisor);
                while (num % divisor == 0) {
                    num /= divisor;
                }
            }
            return primeFactors.size();
        }
    }

}
