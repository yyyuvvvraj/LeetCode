package DailyChallenges.Easy;
//Problem-2379
public class minimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int countB = 0, maxCountB = 0;

        // Count 'B's in the first window of size k
        for (int i = 0; i < k; ++i) {
            if (blocks.charAt(i) == 'B') {
                ++countB;
            }
        }
        maxCountB = countB; // Initialize maxCountB with the first window

        // Sliding window to check all other windows of size k
        for (int i = k; i < blocks.length(); ++i) {
            if (blocks.charAt(i) == 'B') {
                ++countB;
            }
            if (blocks.charAt(i - k) == 'B') {
                --countB;
            }
            maxCountB = Math.max(maxCountB, countB); // Update the max count of 'B's in any window
        }

        return k - maxCountB; // Minimum recolors needed
    }
}
