import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            String exp = sc.next();
            String converted = "";

            // stack은 연산자의 스택을 사용한다.
            Stack<Character> s = new Stack<>(); // operator stack
            
            // 규칙 1.
            // stack이 있고, 현재 문자 c와 비교한다.
            // 1. c가 피연산자라면 -> 그대로 출력
            // 2. c가 연산자라면 
            //    - 2.1. 스택이 비어있다면 -> 그대로 넣기
            //    - 2.2.  비어있지 않다면 top과 비교
            //         - 2.2.1. top이 낮다면 -> 현재 c를 push
            //         - 2.2.2. top과 같다면 -> 현재 top을 pop하여 출력한 후, 현재 c를 push
            //         - 2.2.3. top이 높다면 -> 높은 것들을 모두 pop하여 출력
            //                               (같은 것과 만날 때까지, 같은 것을 만나면 현재 top을 pop후 현재 c를 push
            // 3. c가 여는 괄호라면 -> 무조건 push
            // 4. c가 닫는 괄호라면 -> 여는 괄호를 만날 때까지 pop
            
            
            for(int i=0; i<exp.length(); i++) {
                char c = exp.charAt(i);
                if(c == '*') {
                    if(s.isEmpty()) s.push(c);
                    else if(s.peek() == '+') s.push(c);
                    else if(s.peek() == '*') {
                        converted += s.pop();
                        s.push(c);
                    }
                    else if(s.peek() == '(') s.push(c);
                }else if(c == '+') {
                    if(s.isEmpty()) s.push(c);
                    else if(s.peek() == '+') {
                        converted += s.pop();
                        s.push(c);
                    } else if(s.peek() == '*') {
                        while(!s.isEmpty() && s.peek() == '*') {
                            converted += s.pop();
                        }
                        if(!s.isEmpty() && s.peek() == '+') {
                            converted += s.pop();
                        }
                        s.push(c);
                    } else if(s.peek()== '(') s.push(c);
                } else  if(c-'0' >= 0 && c-'0' <= 9) {
                    converted += c;
                } else if(c == '(') {
                    s.push(c);
                } else if(c == ')') {
                    while(s.peek()!='(') {
                        converted += s.pop();
                    }
                    s.pop();
                }
            }
            while(!s.isEmpty())
                converted += s.pop();
//            System.out.println(converted);
            
            
            // 피 연산자의 스택을 사용한다.
            Stack<Integer> s2 = new Stack<>();
            for(int i=0; i<converted.length(); i++) {
                char c = converted.charAt(i);
                if(c - '0' >= 0 && c - '0' <= 9) {
                    s2.push(c-'0');
                } else if (c == '+') {
                    int num1 = s2.pop();
                    int num2 = s2.pop();
                    s2.push(num1+ num2);
                } else if(c == '*') {
                    s2.push(s2.pop() * s2.pop());
                }
            }
            System.out.println("#"+tc+" "+s2.pop());
        }
    }
}