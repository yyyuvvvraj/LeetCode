package DailyChallenges.Hard;

import DailyChallenges.Medium.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

//Problem-2503
public class maxPoints {
    class T{
        int i;
        int j;
        int val;
        public T(int i,int j,int val){
            this.i=i;
            this.j=j;
            this.val=val;
        }
    }
    class Solution {
        public int[] maxPoints(int[][] grid, int[] queries) {
            int m=grid.length;
            int n=grid[0].length;
            final int[] dirs={0,1,0,-1,0};
            int ans[]=new int[queries.length];
            Pair<Integer,Integer>[] queryAndIndexes=new Pair[queries.length];
            Queue<T> minHeap=new PriorityQueue<>((a, b)->a.val-b.val);
            boolean[][] seen=new boolean[m][n];
            for(int i=0;i<queries.length;++i){
                queryAndIndexes[i]=new Pair<>(queries[i],i);
            }
            Arrays.sort(queryAndIndexes,(a, b)->a.getKey()-b.getKey());
            minHeap.offer(new T(0,0,grid[0][0]));
            seen[0][0]=true;
            int accumulate=0;
            for(Pair<Integer,Integer> pair:queryAndIndexes){
                int query=pair.getKey();
                int index=pair.getValue();
                while(!minHeap.isEmpty()){
                    int i=minHeap.peek().i;
                    int j=minHeap.peek().j;
                    int val=minHeap.poll().val;
                    if(val>=query){
                        minHeap.offer(new T(i,j,val));
                        break;
                    }
                    ++accumulate;
                    for(int k=0;k<4;++k){
                        final int x=i+dirs[k];
                        int y=j+dirs[k+1];
                        if(x<0||x==m||y<0||y==n){
                            continue;
                        }
                        if(seen[x][y]){
                            continue;
                        }
                        minHeap.offer(new T(x,y,grid[x][y]));
                        seen[x][y]=true;
                    }
                }
                ans[index]=accumulate;
            }
            return ans;
        }
    }
}
