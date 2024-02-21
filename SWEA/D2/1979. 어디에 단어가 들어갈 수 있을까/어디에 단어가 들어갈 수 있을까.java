import java.io.File;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1979_어디에_단어가_들어갈_수_있을까/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;   // 테스트 케이스의 개수
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt() ;      // 퍼즐의 가로, 세로 길이
			int K = sc.nextInt() ;      // 단어의 길이
			
			int[][] puzzle = new int [N][N] ;       // 퍼즐 배열
			
			// 퍼즐의 모양 입력 (흰색 부분 1, 검은색 부분 0)
			for(int r=0; r<puzzle.length; r++) {
				for(int c=0; c<puzzle[r].length; c++) {
					puzzle[r][c] = sc.nextInt() ;
				}
			}
			
			int[] lenArr = new int [N+1] ;      // 퍼즐 배열에서 만들 수 있는 문자의 길이
			
			// 가로 탐색
			for(int r=0; r<puzzle.length; r++) {
				int len = 0 ;
				for(int c=0; c<puzzle.length; c++) {
					// 검은색 부분을 만나면 
					if(puzzle[r][c] == 0) {
						lenArr[len]++ ; 
						len = 0 ;
						continue ;
					}
					
					len ++ ;    // 흰색부분이면 가능한 길이 + 1
					
					//마지막 부분에 도착하면 
					if(c == puzzle.length-1) {
						lenArr[len]++ ;     
						len = 0 ;
						break ;
					}
				}
			}
			
			// 세로 탐색
			for(int c=0; c<puzzle.length; c++) {
				int len = 0;
				for(int r=0; r<puzzle.length; r++) {
					// 검은색 부분을 만나면
					if(puzzle[r][c] == 0) {
						lenArr[len]++ ; 
						len = 0 ;
						continue ;
					}
					
					len ++ ;   // 흰색부분이면 가능한 길이 + 1
					
					//마지막 부분에 도착하면 
					if(r == puzzle.length-1) {
						lenArr[len]++ ;     
						len = 0 ;
						break ;
					}
				}
			}
			
			// 정답 출력
			for(int i=1; i<lenArr.length; i++) {
				if (i == K) {
					System.out.printf("#%d %d\n", test_case, lenArr[i]);
					break ;
				}
			}
			
		}
		
	}
	
}
