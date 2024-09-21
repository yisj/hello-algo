import java.util.Stack;

public class Solution {

    boolean solution(String s) {

        Stack<Character> stack = new Stack<>(); // 여는 괄호의 스택
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }
    
}
