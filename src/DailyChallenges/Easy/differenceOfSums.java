package DailyChallenges.Easy;
//Problem-2894
public class differenceOfSums {
    class Solution {
        public int differenceOfSums(int n, int m) {
            int sum=(1+n)*n/2;
            int num2=getDivisibleSum(n,m);
            int num1=sum-num2;
            return num1-num2;
        }
        private int getDivisibleSum(int n,int m){
            int last=n/m*m;
            if(last==0){
                return 0;
            }
            int first=m;
            int count=(last-first)/m+1;
            return (first+last)*count/2;
        }
    }
}
