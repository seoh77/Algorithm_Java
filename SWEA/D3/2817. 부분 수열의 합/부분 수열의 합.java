import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int N ;			// N개의 자연수 수열이 주어짐
	static int K ;			// 합이 K가 되는 경우의 수
	static int[] arr ;		// N개의 자연수 수열을 담아둘 배열
	static int num ;		// 경우의 수를 계산할 변수
	
	public static void main(String[] args) throws Exception {
		
		 // File file = new File("src/swea_2817_부분수열의합/input.txt") ;
		 // Scanner sc = new Scanner(file) ;
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			N = sc.nextInt() ;
			K = sc.nextInt() ;
			arr = new int [N] ;
			num = 0 ;			// 초기화
			
			// N개의 자연수 수열 값 입력
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			sumArr(0, 0) ;
			
			System.out.printf("#%d %d\n", test_case, num);
			
		}
		
	}

	static void sumArr(int idx, int sum) {
		
		if (idx >= arr.length) return ;			// idx 범위가 배열 크기를 벗어나면 return
		
		if (sum + arr[idx] == K) num++ ;		// sum + arr[idx] 값이 K와 같으면 num+1
		
		if (sum + arr[idx] < K) sumArr(idx+1, sum+arr[idx]) ;	  // sum + arr[idx] < K 경우에만 sum+arr[idx] 케이스를 고려
		
		sumArr(idx+1, sum) ;		// 해당 idx가 포함되지 않는 경우
		
	}
	

}