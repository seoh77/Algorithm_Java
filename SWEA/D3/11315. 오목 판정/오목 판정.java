import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_11315_오목판정/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();		
			String[][] arr = new String [N][N] ;	// N * N 크기의 게임판
			
			// 각 칸에 돌이 있는지 없는지 여부 입력받기 ('o' : 돌이 있는 칸 , '.' : 돌이 없는 칸) 
			for(int r=0; r<arr.length; r++) {
				String[] temp = sc.next().split("") ;
				for(int c=0; c<arr[r].length; c++) {
					arr[r][c] = temp[c] ;
				}
			}
			
			String answer = "NO" ;		// 돌이 다섯 개 이상 연속한 부분이 있으면 "YES", 아니면 "NO" 
			
			// 델타배열 설정
			int[] dr = {0, 0, -1, 1, -1, -1, 1, 1} ;
			int[] dc = {-1, 1, 0, 0, -1, 1, 1, -1} ;
			
			// 각 칸을 탐색하며 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 판정
			allbreak:
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr[r].length; c++) {
					// 델타배열을 사용하여 가로, 세로, 대각선 모든 방향 탐색 
					for(int d=0; d<dr.length; d++) {
						int nr = r ;
						int nc = c ; 	// 현재 탐색하고 있는 row, column 번호
						boolean success = true ;		// 다섯개 이상 연속했으면 true, 아니면 false 
						
						// 다섯 개 이상 연속하면 되기 때문에 반복횟수를 5로 설정 
						for(int time=0; time<5; time++) {
							if(nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length || arr[nr][nc].equals(".")) {
								success = false ; 	// 연속 실패 
								break ;				// 이미 돌이 이어지지 않으므로 해당 방향으로는 더이상 탐색할 필요가 없음 
							}
							nr += dr[d] ;
							nc += dc[d] ;
						}
						
						if(success) {
							answer = "YES" ;
							break allbreak;		// 다섯 개 이상 연속했다면 더 이상 탐색할 필요 없이 바로 출력하면 된다.
						}
					}
					
				}
			}
			
			System.out.printf("#%d %s\n", test_case, answer);
			
		}
		
		sc.close(); 
		
	}

}
