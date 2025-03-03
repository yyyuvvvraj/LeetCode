package DailyChallenges.Medium;
//Problem-2161
public class pivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans=new int[nums.length];
        int i=0;
        for(final int num:nums){
            if(num<pivot){
                ans[i++]=num;
            }
        }
        for(final int num:nums){
            if(num==pivot){
                ans[i++]=num;
            }
        }
        for(final int num:nums){
            if(num>pivot){
                ans[i++]=num;
            }
        }
        return ans;
    }
}
