package Easy;

import java.util.Stack;

//Problem-20
public class isValid {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else if(st.size()>0&&ch==']'&&st.peek()=='['){
                st.pop();
            }else if(st.size()>0&&ch==')'&&st.peek()=='('){
                st.pop();
            }else if(st.size()>0&&ch=='}'&&st.peek()=='{'){
                st.pop();
            }else{
                return false;
            }
        }
        if(st.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
