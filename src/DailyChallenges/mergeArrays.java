package DailyChallenges;
//Problem-2570
import java.util.ArrayList;
import java.util.List;

public class mergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i=0;
        int j=0;
        List<int[]> res=new ArrayList();
        while(i<nums1.length && j<nums2.length){
            int[] a=nums1[i];
            int[] b=nums2[j];
            if(a[0]==b[0]){
                res.add(new int[]{a[0],a[1]+b[1]});
                i++;
                j++;
            }else if(a[0]<b[0]){
                res.add(a);
                i++;
            }else if(a[0]>b[0]){
                res.add(b);
                j++;
            }
        }
        while(i<nums1.length){
            res.add(nums1[i++]);
        }
        while(j<nums2.length){
            res.add(nums2[j++]);
        }
        return res.toArray(int [][]::new);
    }
}
