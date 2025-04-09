package DailyChallenges.Easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//Problem-3375
public class minOperations {
    Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    final int mn = Arrays.stream(nums).min().getAsInt();
    if (mn < k)

    {
        return -1;
    }
    if (mn > k)

    {
        return numsSet.size();
    }
    return numsSet.size() - 1;
}
}
