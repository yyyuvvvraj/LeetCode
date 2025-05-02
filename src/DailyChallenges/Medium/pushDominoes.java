package DailyChallenges.Medium;
//Probelm-838
public class pushDominoes {
    class Solution {
        public String pushDominoes(String dominoes) {
            char[] s = dominoes.toCharArray();
            int n = s.length;
            int i = 0;

            int left = -1; // Last seen 'L'
            int right = -1; // Last seen 'R'

            while (i <= n) {
                if (i == n || s[i] == 'R') {
                    if (right > left) {
                        // Fill all from right to i with 'R'
                        for (int j = right + 1; j < i; ++j) {
                            s[j] = 'R';
                        }
                    }
                    right = i;
                } else if (s[i] == 'L') {
                    if (right > left) {
                        // Collision: R...L
                        int l = right + 1;
                        int r = i - 1;
                        while (l < r) {
                            s[l++] = 'R';
                            s[r--] = 'L';
                        }
                    } else {
                        // Only 'L' seen: fill leftward
                        for (int j = left + 1; j < i; ++j) {
                            s[j] = 'L';
                        }
                    }
                    left = i;
                }
                i++;
            }

            return new String(s);
        }
    }

}
