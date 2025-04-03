package DailyChallenges.Medium;

import java.util.Stack;

//Problem-394
public class decodeString {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> mainStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {  // Check if the character is a digit
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;  // Adjust because `i` goes one step ahead in the loop
                numberStack.push(num);
            } else if (ch == '[') {
                mainStack.push("[");
            } else if (ch == ']') {
                StringBuilder str = new StringBuilder();

                while (!mainStack.isEmpty() && !mainStack.peek().equals("[")) {
                    str.insert(0, mainStack.pop());
                }

                mainStack.pop(); // Remove the '['

                int repeatCount = numberStack.pop();
                StringBuilder repeatedString = new StringBuilder();

                for (int j = 0; j < repeatCount; j++) {
                    repeatedString.append(str);
                }

                mainStack.push(repeatedString.toString());
            } else {
                mainStack.push(ch + "");
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!mainStack.isEmpty()) {
            ans.insert(0, mainStack.pop());
        }

        return ans.toString();
    }
}
