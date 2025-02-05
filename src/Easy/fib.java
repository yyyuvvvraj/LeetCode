package Easy;
//Problem-509
class Solution2 {
    public int fib(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int f=0;
        int s=1;
        for (int i=1; i<=n; i++){
            int t=f+s;
            f=s;
            s=t;
        }
        return f;
    }
}