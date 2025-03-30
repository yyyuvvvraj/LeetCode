package Medium;

import java.util.Arrays;

//Problem-881
public class numRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start=0;
        int end=people.length-1;
        int count=0;
        while(start<=end){
            if(people[start]+people[end]<=limit){
                start++;
                end--;
            }else{
                end--;
            }
            count++;
        }
        return count;
    }
}
