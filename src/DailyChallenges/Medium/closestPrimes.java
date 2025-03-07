package DailyChallenges.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem-2523
public class closestPrimes {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieveEratosthenes(right + 1);
        List<Integer> primes = new ArrayList<>();

        for (int i = left; i <= right; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = 1; i < primes.size(); ++i) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
            }
        }

        return new int[]{num1, num2};
    }

    private boolean[] sieveEratosthenes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; ++i) {  // Fixed condition
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
