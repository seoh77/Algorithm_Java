import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_4615_재미있는_오셀로게임/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T= sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();					// 보드의 한 변의 길이
			String[][] arr = new String [N][N] ;	// 게임판 배열 
			
			// 게임을 시작하기 전 정가운데에 돌을 미리 배치
			arr[N/2-1][N/2-1] = "W" ;
			arr[N/2-1][N/2] = "B" ;
			arr[N/2][N/2-1] = "B" ;
			arr[N/2][N/2] = "W" ;
			
			int M = sc.nextInt(); 					// 플레이어가 돌을 놓는 횟수
			
			for(int m=0; m<M; m++) {
				// 플레이어가 돌을 놓은 위치 
				int pointC = sc.nextInt() - 1 ;
				int pointR = sc.nextInt() - 1 ;
				String color = (sc.nextInt() == 1) ? "B" : "W" ;	// 1이 입력되면 흑돌, 2가 입력되면 백돌 
				
				arr[pointR][pointC] = color ;	// 게임판에 돌 놓기 
				
				// 델타배열 설정
				int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1} ;
				int[] dc = {0, 0, -1, 1, 1, 1, -1, -1} ;
				
				for(int d=0; d<8; d++) {
					// 탐색할 위치 설정
					int r = pointR + dr[d] ;
					int c = pointC + dc[d] ;
					
					while(true) {
						// 게임판 크기에서 벗어낫거나 해당 요소(arr[r][c]의 값이 null이면 break) 
						if (r<0 || r>=arr.length || c<0 || c>=arr.length || arr[r][c] == null) break ;
						
						// 같은 색깔이 아니라면 pass
						if(!arr[r][c].equals(color)) {
							r += dr[d] ;
							c += dc[d] ;
							continue ;
						}
						
						// 같은 색깔이라면 arr[pointR][pointC] ~ arr[r][c] 사이에 있는 모든 요소 색깔 변경
						while(true) {
							if (r == pointR && c == pointC) break ;
							
							arr[r][c] = color ;
							
							r -= dr[d] ;
							c -= dc[d] ;
						}
						
						break;
						
					}
				}
			}
			
			// 흑돌, 백돌의 개수 구하기
			int blackNum = 0 ;
			int whiteNum = 0 ;
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr[r].length; c++) {
					if (arr[r][c] == null) continue ;
					else if(arr[r][c].equals("B")) blackNum++ ;
					else if(arr[r][c].equals("W")) whiteNum++ ;
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d %d\n", test_case, blackNum, whiteNum);
			
		}
		
		sc.close() ;
		
	}

}
