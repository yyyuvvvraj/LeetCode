package DailyChallenges.Medium;

import java.util.Arrays;
//Problem-3356
public class canMakeZero {
    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            diff[l] -= val;
            if (r + 1 < n) {
                diff[r + 1] += val;
            }
        }
        int[] tmp = Arrays.copyOf(nums, n);
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            tmp[i] += curr;
            if (tmp[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int left = 0;
        int right = m;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (canMakeZero(nums, queries, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
