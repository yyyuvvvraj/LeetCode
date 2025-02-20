package Medium;
//Problem-334
public class increasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        int third=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            if(first>ele){
                first=ele;
            }else if(second>=ele){
                second=ele;
            }else{
                third=ele;
                return true;
            }
        }
        return false;
    }
    //Alternatively
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num <= first) {
                    first = num;    // num is now the smallest value
                } else if (num <= second) {
                    second = num;   // num is bigger than first but smaller than second
                } else {
                    // num is bigger than both first and second
                    return true;
                }
            }
            return false;
        }
    }

}
