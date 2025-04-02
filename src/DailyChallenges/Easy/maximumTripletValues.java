package DailyChallenges.Easy;
//Problem-2873
public class maximumTripletValues {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        int maxDiff=0;
        int maxNum=0;
        for(int num:nums){
            ans=Math.max(ans,(long) maxDiff*num);
            maxDiff=Math.max(maxDiff,maxNum-num);
            maxNum=Math.max(maxNum,num);
        }
        return ans;
    }
}
