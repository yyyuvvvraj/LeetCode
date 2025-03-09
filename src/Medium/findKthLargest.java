package Medium;

import java.util.PriorityQueue;

//Problem-215
public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<nums.length;i++){
            if(pq.size()<k){
                pq.add(nums[i]);
            }else if(pq.peek()<nums[i]){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
