import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		Stack<Integer> stack = new Stack<Integer>() ;
		StringBuilder sb = new StringBuilder() ;
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			String s = sc.next();
			
			if(s.equals("push")) {
				int n = sc.nextInt();
				stack.add(n) ;
			} else if (s.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append("-1\n") ;
				} else {
					sb.append(stack.pop()+"\n") ;
				}
			} else if (s.equals("size")) {
				sb.append(stack.size()+"\n") ;
			} else if (s.equals("empty")) {
				boolean empty = stack.isEmpty() ;
				if (empty) {
					sb.append("1\n") ;
				} else {
					sb.append("0\n") ;
				}
			} else if (s.equals("top")) {
				if (stack.isEmpty()) {
					sb.append("-1\n") ;
				} else {
					sb.append(stack.peek()+"\n") ;
				}
			}
		}
		
		System.out.println(sb);
		
		sc.close();
		
	}
	
}
