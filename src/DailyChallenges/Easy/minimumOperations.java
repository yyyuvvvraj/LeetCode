package DailyChallenges.Easy;

import java.util.HashSet;
import java.util.Set;

//Problem-3396
public class minimumOperations {
    public int minimumOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (!s.add(nums[i])) {
                return i / 3 + 1;
            }
        }
        return 0;
    }
}
