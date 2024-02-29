import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static String[] stack ;
	static int top ;
	
	public static void main(String[] args) throws Exception {
		
		 // File file = new File("src/swea_1218_괄호짝짓기/input.txt") ;
		 // Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = 10 ;		// 테스트 케이스 10개로 고정
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int len = sc.nextInt();		// 입력받을 괄호 문자의 길이 
			stack = new String[len] ;	// 괄호 문자의 길이만큼 스택 생성
			top = -1 ;					// top -1로 초기화 
			
			int answer = 1 ;			// 유효성 여부 (1 : 유효함 , 0 : 유효하지 않음)
			
			String[] strArr = sc.next().split("") ;		// 괄호 문자 입력받아서 문자 하나씩 잘라 배열에 넣기
			
			for(int i=0; i<strArr.length; i++) {
				// '(' , '[' , '{', '<' 와 같은 여는 괄호가 나오면 스택에 push
				if (strArr[i].equals("(") || strArr[i].equals("[") || strArr[i].equals("{") || strArr[i].equals("<")) {
					push(strArr[i]) ;
				} else {
					// 닫는 괄호가 나오면 스택 pop
					String popStr = pop() ;
					
					if (strArr[i].equals(")")) {
						if (!popStr.equals("(")) {
							answer = 0 ;
							break ;
						}
					} else if (strArr[i].equals("]")) {
						if (!(popStr.equals("["))) {
							answer = 0 ;
							break ;
						}
					} else if (strArr[i].equals("}")) {
						if (!(popStr.equals("{"))) {
							answer = 0 ;
							break ;
						}
					} else if (strArr[i].equals(">")) {
						if(!(popStr.equals("<"))) {
							answer = 0 ;
							break ;
						}
					}
				}
			}
			
			// 끝났을 때, 스택에 남아있는 값이 있으면 answer = 0 
			if(!isEmpty()) {
				answer = 0 ;
			}
			
			// 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
		
	}
	
	/**
	 * 스택이 비어있는지 확인하는 메소드 
	 * @return
	 */
	static boolean isEmpty() {
		return top == -1 ;
	}
	
	/**
	 * 스택에 data를 삽입하는 메소드 
	 * @param s
	 */
	static void push(String s) {
		if (top == stack.length-1) {
			// 스택이 전부 찼다면 값을 더 이상 삽입할 수 없음.
			System.out.println("스택이 다 찼습니다.");
			return ;
		}
		
		stack[++top] = s ;
	}
	
	/**
	 * 스택에서 data를 제거하고, 제거한 값을 보여주는 메소드 
	 */
	static String pop() {
		if (isEmpty()) {
			// 스택이 비어있다면 값을 빼낼 수 없음.
			return "ERROR";
		}
		
		return stack[top--] ;
	}

}
