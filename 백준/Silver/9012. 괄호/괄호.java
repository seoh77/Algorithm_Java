import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String[] strArr = sc.next().split("");			// 괄호 문자열 입력
			Stack<String> stack = new Stack<String>() ;		// 스택 생성
			
			String answer = "YES" ;
			
			for(int i=0; i<strArr.length; i++) {
				// 여는 괄호("(")가 입력되면 스택에 넣기
				if(strArr[i].equals("(")) {
					stack.add("(") ;
				} else {
					// stack이 공백이거나 여는 괄호가 없으면 "NO"가 출력
					if(stack.isEmpty() || !stack.pop().equals("(")) {
						answer = "NO" ;
						break ;
					}
				}
			}
			
			// 모든 입력이 다 종료되었음에도 스택에 남아있는 값이 있다면 올바른 괄호 문자열이 아님
			if(!stack.isEmpty()) {
				answer = "NO" ;
			}
			
			System.out.println(answer);
			
		}
		
		sc.close();
		
	}

}
