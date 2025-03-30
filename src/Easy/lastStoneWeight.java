package Easy;

import java.util.Collections;
import java.util.PriorityQueue;

//Problem-1046
public class lastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<> (Collections.reverseOrder());

        for(int ele:stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int max=pq.remove();
            int smax=pq.remove();
            int nstone=max-smax;
            if(nstone!=0){
                pq.add(nstone);
            }
        }
        if(pq.size()==0){
            return 0;
        }else{
            return pq.remove();
        }
    }
}
