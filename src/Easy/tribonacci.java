package Easy;
    class Solution3 {
        public int tribonacci(int n) {
            if (n==0){
                return 0;
            }else if(n==1 || n==2){
                return 1;
            }else{
                int Fir=0;
                int Sec=1;
                int Thi=1;
                for(int i=1;i<=n;i++){
                    int Fou=Fir+Sec+Thi;
                    Fir=Sec;
                    Sec=Thi;
                    Thi=Fou;
                }
                return Fir;
            }

        }
    }

