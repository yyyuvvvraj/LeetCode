package Medium;
//Problem-151
public class reverseWords {
    public String reverseWords(String s) {
        String[] arr=s.split("\\s+");
        StringBuilder sb=new StringBuilder("");
        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]+" ");
        }
        String ans=sb.toString();
        ans=ans.trim();
        return ans;
    }
}
