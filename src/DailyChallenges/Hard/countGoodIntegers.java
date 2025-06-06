package DailyChallenges.Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Problem-3272
public class countGoodIntegers {
    public long countGoodIntegers(int n, int k) {
        int halfLength = (n + 1) / 2;
        int minHalf = (int)Math.pow(10, halfLength - 1);
        int maxHalf = (int)Math.pow(10, halfLength);
        long ans = 0;
        Set<String> seen = new HashSet<>();

        for (int num = minHalf; num < maxHalf; ++num) {
            String firstHalf = String.valueOf(num);
            String secondHalf = new StringBuilder(firstHalf).reverse().toString();
            String palindrome = firstHalf + secondHalf.substring(n % 2);

            if (Long.parseLong(palindrome) % k != 0) {
                continue;
            }

            char[] sortedDigits = palindrome.toCharArray();
            Arrays.sort(sortedDigits);
            String sortedDigitsStr = new String(sortedDigits);

            if (seen.contains(sortedDigitsStr)) {
                continue;
            }

            seen.add(sortedDigitsStr);

            int[] digitCount = new int[10];
            for (char c : palindrome.toCharArray()) {
                ++digitCount[c - '0'];
            }

            int firstDigitChoices = n - digitCount[0];
            long permutations = firstDigitChoices * factorial(n - 1);

            for (final int freq : digitCount) {
                if (freq > 1) {
                    permutations /= factorial(freq);
                }
            }

            ans += permutations;
        }

        return ans;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; ++i) {
            res *= i;
        }
        return res;
    }
}
