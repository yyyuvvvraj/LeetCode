package DailyChallenges.Medium;

import java.util.Stack;

//Problem-2434
public class robotWithString {
    class Solution {
        public String robotWithString(String s) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }

            Stack<Character> stack = new Stack<>();
            StringBuilder res = new StringBuilder();
            char minCharacter = 'a';

            for (char c : s.toCharArray()) {
                stack.push(c);
                cnt[c - 'a']--;

                // Move to the next smallest available character
                while (minCharacter <= 'z' && cnt[minCharacter - 'a'] == 0) {
                    minCharacter++;
                }

                // Greedily pop from the stack if it is less than or equal to minCharacter
                while (!stack.isEmpty() && stack.peek() <= minCharacter) {
                    res.append(stack.pop());
                }
            }

            // Pop any remaining characters in the stack
            while (!stack.isEmpty()) {
                res.append(stack.pop());
            }

            return res.toString();
        }
    }

}
