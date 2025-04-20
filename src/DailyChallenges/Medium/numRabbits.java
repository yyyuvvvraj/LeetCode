package DailyChallenges.Medium;
//Problem-781
public class numRabbits {
    public int numRabbits(int[] answers) {
        int ans=0;
        int[] count=new int[1000];
        for(int answer:answers){
            if(count[answer]%(answer+1)==0){
                ans+=answer+1;
            }
            ++count[answer];
        }
        return ans;
    }
}
