package algorithms;

import java.util.HashMap;
import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        String str = "(){}[]{{";
//        isValidSub(str);
        System.out.println(isValidSub(str));
    }

    public static boolean isValidSub(String s){
        if(s == null || s.length()%2 != 0 || s.equals("")) return false;
        while(s.length() != 0){
            if(s.indexOf("()") >= 0){
                s = s.substring(0, s.indexOf("()")) + s.substring(s.indexOf("()") + 2);
                System.out.println(s);
            } else if(s.indexOf("{}") >= 0){
                s = s.substring(0, s.indexOf("{}")) + s.substring(s.indexOf("{}") + 2);
                System.out.println(s);
            } else if(s.indexOf("[]") >= 0){
                s = s.substring(0, s.indexOf("[]")) + s.substring(s.indexOf("[]") + 2);
                System.out.println(s);
            } else {
                return false;
            }
        }
        return true;
    }

    class Solution {

        // Hash table that takes care of the mappings.
        private HashMap<Character, Character> mappings;

        // Initialize hash map with mappings. This simply makes the code easier to read.
        public Solution() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        public boolean isValid(String s) {

            // Initialize a stack to be used in the algorithm.
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // If the current character is a closing bracket.
                if (this.mappings.containsKey(c)) {

                    // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                    char topElement = stack.empty() ? '#' : stack.pop();

                    // If the mapping for this bracket doesn't match the stack's top element, return false.
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    // If it was an opening bracket, push to the stack.
                    stack.push(c);
                }
            }

            // If the stack still contains elements, then it is an invalid expression.
            return stack.isEmpty();
        }
    }
}
