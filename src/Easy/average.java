package Easy;
//Problem-1491
public class average {
    public double average(int[] salary) {
        int max=salary[0];
        int min=salary[0];
        int sum=0;
        for(int i=0;i<salary.length;i++){
            if(max<salary[i]){
                max=salary[i];
            }
            if(min>salary[i]){
                min=salary[i];
            }
            sum=sum+salary[i];
        }
        sum=sum-min-max;
        double ans=(double)sum/(salary.length-2);
        return ans;
    }
}
