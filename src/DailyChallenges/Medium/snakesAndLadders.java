package DailyChallenges.Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//Problem-909
public class snakesAndLadders {
    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n=board.length;
            int ans=0;
            Queue<Integer> q=new ArrayDeque<>(Arrays.asList(1));
            boolean[] seen=new boolean[1+n*n];
            int[] A=new int[1+n*n];
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    A[(n-1-i)*n+((n-i&1)==1?j+1:n-j)]=board[i][j];
                }
            }
            while(!q.isEmpty()){
                ++ans;
                for(int sz=q.size();sz>0;--sz){
                    int curr=q.poll();
                    for(int next=curr+1;next<=Math.min(curr+6,n*n);++next){
                        int dest=A[next]>0?A[next]:next;
                        if(dest==n*n){
                            return ans;
                        }
                        if(seen[dest]){
                            continue;
                        }
                        q.offer(dest);
                        seen[dest]=true;
                    }
                }
            }
            return -1;
        }
    }
}
