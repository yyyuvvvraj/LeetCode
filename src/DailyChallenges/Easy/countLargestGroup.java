package DailyChallenges.Easy;
//Problem-1399
import java.util.HashMap;
import java.util.Map;

public class countLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> HashMap=new HashMap<Integer,Integer>();
        int maxValue=0;
        for(int i=1;i<=n;++i){
            int key=0,i0=i;
            while(i0!=0){
                key+=i0%10;
                i0/=10;
            }
            HashMap.put(key,HashMap.getOrDefault(key,0)+1);
            maxValue=Math.max(maxValue,HashMap.get(key));
        }
        int count=0;
        for(Map.Entry<Integer,Integer> kvpair:HashMap.entrySet()){
            if(kvpair.getValue()==maxValue){
                ++count;
            }
        }
        return count;
    }
}
