import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_6485_삼성시의_버스노선/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt() ;		// N개의 버스 노선
			int[] arr = new int [5001] ; 	// 5000개의 버스 정류장 배열 
			
			// 각 버스 노선이 지나는 버스 정류장 (A이상 B이하)
			for(int i=0; i<N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt(); 
				
				// 버스가 지나갈 경우 버스 정류장 배열의 요소 값을 +1
				for(int j=A; j<=B; j++) {
					arr[j]++ ;
				}
			}
			
			// P개의 버스 정류장에 대해 각 정류장에 몇 개의 버스 노선이 다니는지 구하기
			int P = sc.nextInt();
			
			// 해당하는 정류장에 몇 개의 버스 노선이 다니는지 출력
			System.out.printf("#%d", test_case);
			for(int i=0; i<P; i++) {
				int C = sc.nextInt() ;
				System.out.printf(" %d", arr[C]);
			}
			System.out.println();
			
		}
		
		sc.close() ;
	}

}
