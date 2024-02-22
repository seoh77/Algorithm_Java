import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
	
	// File file = new File("src/swea_1859_백만장자프로젝트/input.txt") ;
	// Scanner sc = new Scanner(file) ;
	
	Scanner sc = new Scanner(System.in) ;
	
	int T = sc.nextInt() ;         // 테스트 케이스 수
	
	for(int test_case=1; test_case<=T; test_case++) {
		int N = sc.nextInt() ;         // 연속된 N일 동안의 물건의 매매가를 예측해서 알고 있음
		
		int[] arr = new int [N] ;      // 알고있는 매매가
		
		// 매매가 입력받기
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt() ;
		}
		
		long total = 0 ;         // 최대 이익을 계산하기 위한 변수
		int pCount = 0 ;        // 구매한 물건 수량
		
		int start = 0 ;         // 
		
		while(true) {
			int idx = searchMaxIdx(arr, start) ;
			
			for(int i=start; i<idx; i++) {
				total -= arr[i] ;
				pCount++ ;
			}
			
			total += (arr[idx]*pCount) ;
			
			if(idx == arr.length-1) break ; 
			
			start = idx + 1;
			pCount = 0;
			
		}
		
		System.out.printf("#%d %d\n", test_case, total);
		
		}	
	}
	
	static int searchMaxIdx(int[] arr, int start) {
		int max = 0 ;
		int idx = -1 ;
		
		for(int i=start; i<arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i] ;
				idx = i ;
			} 
		}
		return idx ;
		
	}

}
