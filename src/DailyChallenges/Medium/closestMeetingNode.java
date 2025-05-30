package DailyChallenges.Medium;
import java.util.Arrays;

//Problem-2359
public class closestMeetingNode {
    class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int[] dist1 = getDist(edges, node1);
            int[] dist2 = getDist(edges, node2);
            int minDist = Integer.MAX_VALUE;
            int ans = -1;

            for (int i = 0; i < edges.length; ++i) {
                if (dist1[i] >= 0 && dist2[i] >= 0) {
                    int maxDist = Math.max(dist1[i], dist2[i]);
                    if (maxDist < minDist) {
                        minDist = maxDist;
                        ans = i;
                    }
                }
            }
            return ans;
        }

        private int[] getDist(int[] edges, int start) {
            int[] dist = new int[edges.length];
            Arrays.fill(dist, -1);
            int d = 0;
            while (start != -1 && dist[start] == -1) {
                dist[start] = d++;
                start = edges[start];
            }
            return dist;
        }
    }


}
