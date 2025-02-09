package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem-989
public class addToArrayForm {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new ArrayList<>();
        int p=num.length-1;
        int carry=0;
        while(p>=0||k>0){
            int numval=0;
            if(p>=0){
                numval=num[p];
            }
            int d=k%10; //It is the last digit from k
            int sum=numval+d+carry;
            int digit=sum%10;
            carry=sum/10;
            ans.add(digit);
            p--; //Moving the pointer
            k=k/10; //Removing the last digit from k
        }
        if(carry>0){
            ans.add(carry); //Adding carry to the array list
        }
        Collections.reverse(ans); //Reversing the array list
        return ans;
    }
}
