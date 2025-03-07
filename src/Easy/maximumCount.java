package Easy;
//Problem-2529
public class maximumCount {
    public int maximumCount(int[] nums) {
        int lastnegIndex = lastNegative(nums) + 1;  // Count of negative numbers
        int firposIndex = nums.length - firstPositive(nums);  // Count of positive numbers
        return Math.max(lastnegIndex, firposIndex);
    }

    private int lastNegative(int[] nums) {
        int start = 0, end = nums.length - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < 0) {  // Only consider negative numbers
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private int firstPositive(int[] nums) {
        int start = 0, end = nums.length - 1, ans = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > 0) {  // Only consider positive numbers
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
