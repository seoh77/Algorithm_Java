import java.util.Scanner;

public class Solution {
	
	static int N ;
	static int M ;
	static int answer ;
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1217_거듭제곱/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = 10;					// 테스트 케이스의 수 (10개로 고정)
		
		for(int test_case=1; test_case<=T; test_case++) {
			int testNum = sc.nextInt() ;		// 테스트 케이스 번호
			
			// N의 M 거듭제곱 값 구하기
			N = sc.nextInt();
			M = sc.nextInt();	
			answer = 1 ;
			
			calcu(0) ;
			
			System.out.printf("#%d %d\n", testNum, answer);
			
		}
		
		sc.close() ;
		
	}

	private static void calcu(int curNum) {
		if (curNum == M) return ;
		answer *= N ;
		calcu(++curNum) ;
	}

}
