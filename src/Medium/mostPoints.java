package Medium;
//Problem-2140
public class mostPoints {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n+1];
        for(int i=n-1;i>=0;--i){
            int points=questions[i][0];
            int brainpower=questions[i][1];
            int nextIndex=i+brainpower+1;
            long nextPoints=nextIndex<n?dp[nextIndex]:0;
            dp[i]=Math.max(points+nextPoints,dp[i+1]);
        }
        return dp[0];
    }
}
