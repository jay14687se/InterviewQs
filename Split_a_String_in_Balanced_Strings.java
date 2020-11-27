package algorithms;

import java.util.Stack;

public class Split_a_String_in_Balanced_Strings {
    public int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int r = 0;
        for(int i = 0; i< s.length(); i++){
            if(stack.empty() == false && stack.peek() != s.charAt(i)){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }

            if(stack.empty()){
                r++;
            }
        }
        return r;
    }

    public int balancedStringSplit1(String s) {
        int count=0,ans=0;
        for(char c:s.toCharArray()){
            if(c=='R')count++;
            else count--;
            if(count==0)ans++;
        }
        return ans;
    }
}
