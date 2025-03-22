package DailyChallenges.Medium;

import java.util.HashSet;
import java.util.Set;

//Problem-2685
public class countCompleteComponents {
    class UnionFind {
        int[] id;
        int[] rank;
        int[] nodeCount;
        int[] edgeCount;

        public UnionFind(int n) {
            id = new int[n];
            rank = new int[n];
            nodeCount = new int[n];
            edgeCount = new int[n];

            for (int i = 0; i < n; ++i) {
                id[i] = i;
                nodeCount[i] = 1;
            }
        }

        public void unionByRank(int u, int v) {
            int i = find(u);
            int j = find(v);
            ++edgeCount[i];

            if (i == j) {
                return;
            }

            if (rank[i] < rank[j]) {
                id[i] = j;
                edgeCount[j] += edgeCount[i];
                nodeCount[j] += nodeCount[i];
            } else if (rank[i] > rank[j]) {
                id[j] = i;
                edgeCount[i] += edgeCount[j];
                nodeCount[i] += nodeCount[j];  // Fix: Correctly update node count
            } else {
                id[i] = j;
                edgeCount[j] += edgeCount[i];
                nodeCount[j] += nodeCount[i];
                ++rank[j];
            }
        }

        public int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u])); // Path compression
        }

        public boolean isComplete(int u) {
            int root = find(u);
            return nodeCount[root] * (nodeCount[root] - 1) / 2 == edgeCount[root]; // Correct check
        }
    }

    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            int ans = 0;
            UnionFind uf = new UnionFind(n);
            Set<Integer> parents = new HashSet<>();

            for (int[] edge : edges) {
                uf.unionByRank(edge[0], edge[1]);
            }

            for (int i = 0; i < n; ++i) {
                int parent = uf.find(i);
                if (parents.add(parent) && uf.isComplete(parent)) {
                    ++ans;
                }
            }

            return ans; // Fix: Return the final answer
        }
    }
}
