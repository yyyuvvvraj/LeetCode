package DailyChallenges.Medium;

import java.util.Arrays;

//Problem-2145
public class numberOfArrays {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long[] prefix=new long[differences.length+1];
        for(int i=0;i<differences.length;++i){
            prefix[i+1]+=prefix[i]+differences[i];
        }
        long max= Arrays.stream(prefix).max().getAsLong();
        long min=Arrays.stream(prefix).min().getAsLong();
        return (int)Math.max(0L,(upper-lower)-(max-min)+1);
    }
}
