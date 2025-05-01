package DailyChallenges.Hard;

import java.util.TreeMap;

//Problem-2071
public class maxTaskAssign {
    class Solution {
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
            int ans=0;
            int l=0;
            int r=Math.min(tasks.length,workers.length);
            Arrays.sort(tasks);
            Arrays.sort(workers);
            while(l<=r){
                final int m=(l+r)/2;
                if(canComplete(tasks,workers,pills,strength,m)){
                    ans=m;
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            return ans;
        }
        private boolean canComplete(int[] tasks, int[] workers, int pills, int strength, int k) {
            TreeMap<Integer, Integer> sortedWorkers = new TreeMap<>();
            for (int i = workers.length - k; i < workers.length; ++i) {
                sortedWorkers.merge(workers[i], 1, Integer::sum);
            }

            for (int i = k - 1; i >= 0; --i) {
                int task = tasks[i];

                // Try to assign without a pill
                Integer worker = sortedWorkers.ceilingKey(task);
                if (worker != null) {
                    sortedWorkers.merge(worker, -1, Integer::sum);
                    if (sortedWorkers.get(worker) == 0) {
                        sortedWorkers.remove(worker);
                    }
                    continue;
                }

                // Try to assign with a pill
                if (pills > 0) {
                    // Find the weakest worker who can complete the task with a pill
                    worker = sortedWorkers.ceilingKey(task - strength);
                    if (worker != null) {
                        sortedWorkers.merge(worker, -1, Integer::sum);
                        if (sortedWorkers.get(worker) == 0) {
                            sortedWorkers.remove(worker);
                        }
                        pills--;
                        continue;
                    }
                }

                // Task can't be assigned
                return false;
            }
            return true;
        }
    }
}
