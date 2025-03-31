package DailyChallenges.Hard;

import java.util.Arrays;

//Problem-2551
public class putMarbles {
    public long putMarbles(int[] weights, int k) {
        long[] A = new long[weights.length - 1];
        long min = 0;
        long max = 0;

        for (int i = 0; i < A.length; ++i) {
            A[i] = (long) weights[i] + weights[i + 1];
        }

        Arrays.sort(A);

        for (int i = 0; i < k - 1; ++i) {
            min += A[i];
            max += A[A.length - 1 - i];
        }

        return max - min;
    }
}
