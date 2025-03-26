package Easy;

import java.util.Stack;

//Problem-232
public class MyQueue {
    class Queue {
        private Stack<Integer> main;
        private Stack<Integer> helper;

        public Queue() {
            main=new Stack<>();
            helper=new Stack<>();
        }

        public void push(int x) {
            //add all elements of main to helper
            while(main.size()>0){
                helper.push(main.pop());
            }
            //add x to main
            main.push(x);
            //add all elemets from helper to main
            while(helper.size()>0){
                main.push(helper.pop());
            }

        }

        public int pop() {
            return main.pop();

        }

        public int peek() {
            return main.peek();
        }

        public boolean empty() {
            return main.size()==0;
        }
    }

/**
 * Your Queue object will be instantiated and called as such:
 * Queue obj = new Queue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
