package DailyChallenges.Easy;

import java.util.Arrays;

//Problem-2206
public class divideArray {
    public boolean divideArray(int[] nums) {
        int[] count=new int[501];
        for(int num:nums){
            ++count[num];
        }
        return Arrays.stream(count).allMatch(c->c%2==0);
    }
}
