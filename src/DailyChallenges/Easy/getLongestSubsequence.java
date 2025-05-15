package DailyChallenges.Easy;

import java.util.ArrayList;
import java.util.List;

//Problem-2900
public class getLongestSubsequence {
    class Solution {
        // Updated Method
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            List<String> result = new ArrayList<>();
            int previousGroup = -1;

            for (int i = 0; i < words.length; ++i) {
                if (groups[i] != previousGroup) {
                    result.add(words[i]);
                    previousGroup = groups[i];
                }
            }

            return result;
        }
    }
}
