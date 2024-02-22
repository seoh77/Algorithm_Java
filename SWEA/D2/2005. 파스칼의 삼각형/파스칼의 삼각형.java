import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_2005_파스칼의삼각형/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;         // 테스트 케이스 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt() ;     // 파스칼 삼각형의 크기
			int[][] arr = new int [N][N] ;  // 파스칼 삼각형 값을 담아둘 배열
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<=r; c++) {
					if(c == 0 || c == r) {
						arr[r][c] = 1;
						continue ;
					}
					arr[r][c] = arr[r-1][c-1] + arr[r-1][c] ;
				}
			}
			
			// 출력
			System.out.println("#" + test_case);
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] == 0) continue ;
					System.out.print(arr[r][c]+" ");
				}
				System.out.println();
			}
			
		}
		
	}

}
