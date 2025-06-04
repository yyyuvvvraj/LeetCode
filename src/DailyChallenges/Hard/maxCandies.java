package DailyChallenges.Hard;

import java.util.ArrayDeque;

//Problem-1298
public class maxCandies {
    class Solution {
        public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
            int ans=0;
            Queue<Integer> q=new ArrayDeque<>();
            boolean[] reachedClosedBoxes=new boolean[status.length];
            pushBoxesIfPossible(initialBoxes,status,q,reachedClosedBoxes);
            while(!q.isEmpty()){
                int currBox=q.poll();
                ans+=candies[currBox];
                for(int key:keys[currBox]){
                    if(status[key]==0 && reachedClosedBoxes[key]){
                        q.offer(key);
                    }
                    status[key]=1;
                }
                pushBoxesIfPossible(containedBoxes[currBox],status,q,reachedClosedBoxes);
            }
            return ans;
        }
        private void pushBoxesIfPossible(int[] boxes,int[] status,Queue<Integer> q,boolean[] reachedClosedBoxes){
            for(int box:boxes) {
                if (status[box] == 1) {
                    q.offer(box);
                } else {
                    reachedClosedBoxes[box] = true;
                }
            }
        }
    }

}
