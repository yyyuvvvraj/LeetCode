package Easy;
//Problem-1800
public class maxAscendingsum {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int currmax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                currmax += nums[i];  // Continue summing in an ascending sequence
            } else {
                max = Math.max(max, currmax);  // Update max if needed
                currmax = nums[i];  // Reset currmax to the current element
            }
        }
        max = Math.max(max, currmax);  // Final update after loop
        return max;
    }
}
