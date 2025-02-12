package Easy;
//Problem-268
public class missingNumber {
    public int missingNumber(int[] nums) {
        int range=nums.length;
        int actualSum=(range*(range+1))/2;
        int currSum=0;
        for(int i=0;i<nums.length;i++){
            currSum=currSum+nums[i];
        }
        int ans=actualSum-currSum;
        return ans;
    }
}
