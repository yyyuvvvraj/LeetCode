package Medium;
//Problem-53
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int currSum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(currSum+nums[i]>nums[i]){
                currSum+=nums[i];
            }else{
                currSum=nums[i];
            }
            max=Math.max(max,currSum);
        }
        return max;
    }
}
