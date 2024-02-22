import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1961_숫자배열회전/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;     // 테스트 케이스의 개수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt() ;      
			int[][] arr = new int [N][N] ;     // N * N 행렬
			
			// 행렬에 들어가는 값 입력
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr[r].length; c++) {
					arr[r][c] = sc.nextInt() ; 
				}
			}
			
			System.out.println("#" + test_case);
			
			// 90도, 180도, 270도 회전한 모양 출력
			for(int time=0; time<N; time++) {
				
				// 90도 출력
				for(int i=N-1; i>=0; i--) {
					System.out.print(arr[i][time]);
				}
				
				System.out.print(" ");
				
				// 180도 출력
				for(int i=N-1; i>=0; i--) {
					System.out.print(arr[N-time-1][i]);
				}
				
				System.out.print(" ");
				
				// 270도 출력
				for(int i=0; i<N; i++) {
					System.out.print(arr[i][N-time-1]);
				}
				
				System.out.println();
				
			}
			
		}
		
	}

}
