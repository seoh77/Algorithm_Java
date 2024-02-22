import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_2001_파리퇴치/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;        // 테스트 케이스 개수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();        // N*N 배열 안에 파리 존재
			int M = sc.nextInt();		 // M*M 크기의 파리채
			int[][] arr = new int [N][N];
			
			// N*N 배열 안에 존재하는 파리의 개수 입력
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr[r].length; c++) {
					arr[r][c] = sc.nextInt() ;
				}
			}
			
			int max = 0 ;       // 파리채를 한 번 내리쳐 죽인 최대 파리의 개수
			
			for(int r=0; r<=arr.length-M; r++) {
				for(int c=0; c<=arr[r].length-M; c++) {
					
					int total = 0 ;        // 이번에 죽인 파리의 개수
					for(int killR=r; killR<r+M; killR++) {
						for(int killC=c; killC<c+M; killC++) {
							total += arr[killR][killC] ;
						}
					}
					
					// 최댓값 갱신
					max = (total > max) ? total : max ;
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d\n", test_case, max);
		}
		
		sc.close() ;
		
	}
}
