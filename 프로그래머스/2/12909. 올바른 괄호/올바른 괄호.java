import java.util.*;

class Solution {
    
    boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean answer = true;
        
        for(int i=0; i<s.length(); i++) {
            // '('가 입력된 경우 stack에 집어넣기
            if(s.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            
            // ')'가 입력된 경우 stack에 '('가 있는지 확인
            if(stack.isEmpty() || stack.pop() != '(') {
                answer = false;
                break;
            }
        }
        
        // 문자열 탐색이 끝났음에도 스택에 값이 남아있다면 false
        if(!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}