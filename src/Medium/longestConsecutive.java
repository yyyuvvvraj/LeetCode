package Medium;

import java.util.HashMap;

//Problem-128
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],false);
        }
        for(int key:hm.keySet()){
            if(hm.containsKey(key-1)==false){
                hm.put(key,true);
            }
        }
        int max=0;
        for(int key: hm.keySet()){
            int k=1;
            if(hm.get(key)==true){
                while(hm.containsKey(key+k)==true){
                    k++;
                }
            }
            max=Math.max(max,k);
        }
        return max;
    }
}
