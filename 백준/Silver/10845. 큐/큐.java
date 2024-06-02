import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Integer> list ;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in) ;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)) ;
		
		list = new LinkedList<Integer>() ;
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			
			if(s.equals("push")) {
				push(sc.nextInt()) ;
			} else if (s.equals("pop")) {
				bw.write(pop()+"\n");
			} else if (s.equals("size")) {
				bw.write(size()+"\n");
			} else if (s.equals("empty")) {
				bw.write(empty()+"\n");
			} else if (s.equals("front")) {
				bw.write(front()+"\n");
			} else if (s.equals("back")) {
				bw.write(back()+"\n");
			}
		}
		
		bw.flush();
		
		bw.close();
		sc.close();
		
	}

	/**
	 * 큐가 비어있으면 1, 아니면 0을 출력
	 */
	private static int empty() {
		if(list.isEmpty()) {
			return 1 ;
		}
		return 0;
	}

	/**
	 * 정수 n을 큐에 넣는 연산 
	 */
	private static void push(int n) {
		list.add(n) ;
	}

	/**
	 * 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
	 * 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
	 */
	private static int pop() {
		if(empty() == 1) {
			return -1 ;
		}
		
		int num = list.get(0) ;
		list.remove(0) ;
		return num;
	}

	/**
	 * 큐에 들어있는 정수의 개수를 출력
	 */
	private static int size() {
		return list.size();
	}

	/**
	 * 큐의 가장 앞에 있는 정수를 출력
	 * 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
	 */
	private static int front() {
		if(empty() == 1) {
			return -1 ;
		}
		return list.get(0);
	}
	

	/**
	 * 큐의 가장 뒤에 있는 정수를 출력
	 * 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
	 */
	private static int back() {
		if(empty() == 1) {
			return -1 ;
		}
		return list.get(list.size()-1);
	}
}
