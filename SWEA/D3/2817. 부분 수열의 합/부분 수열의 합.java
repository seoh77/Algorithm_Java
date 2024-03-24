import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int[] arr ;			// 자연수 배열
	static int K ;				// 합이 K가 되어야 한다.
	static int answer ;			// 합이 K가 되는 경우의 수
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_2817_부분수열의합/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			// 값 입력받기
			int N = sc.nextInt();		// 자연수 배열의 크기
			arr = new int [N] ;
			K = sc.nextInt() ;
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			answer = 0 ;
			
			combi(0, 0) ;
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
		
		sc.close() ;
		
	}

	private static void combi(int idx, int curSum) {
		if (curSum == K) {
			answer++ ;
			return ;
		}
		
		if(curSum > K || idx >= arr.length) return ;
		
		// 해당 idx를 넣지 않는 경우
		combi(idx+1, curSum) ;
		
		// 해당 idx를 넣는 경우
		combi(idx+1, curSum+arr[idx]) ;
	}

}
