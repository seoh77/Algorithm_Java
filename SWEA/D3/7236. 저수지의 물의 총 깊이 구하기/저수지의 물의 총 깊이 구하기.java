import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_7236_저수지의_물의_총_깊이_구하기/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;		// 테스트 케이스의 수 
		
		// 델타탐색을 위한 델타배열 설정
		int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1} ;
		int[] dc = {0, 0, -1, 1, -1, 1, 1, -1} ;
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();		// 저수지 구획의 크기 
			String[][] arr = new String [N][N] ;		// 저수지 배열 
			
			// 지역 정보 입력받기 (W : 물 , G : 땅) 
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr[r].length; c++) {
					arr[r][c] = sc.next();
				}
			}
			
			int max = 0 ;		// 가장 깊은 물의 깊이 (= 저수지의 총 깊이)
			
			// 가장 깊은 물의 깊이 구하기 
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr.length; c++) {
					
					// 만약 해당 지역(arr[r][c])이 땅이면 pass
					if(arr[r][c].equals("G")) continue ;
					
					// 해당 지역이 물일 경우에만 델타배열을 사용하여 주변에 뭐가 있는지 탐색
					int water = 0 ;			// 주변에 물이 있는 지역이 몇 개인지 계산
					for(int d=0; d<dr.length; d++) {
						int nr = r+dr[d] ;
						int nc = c+dc[d] ;
						
						if(nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[r].length) continue ;	// 저수지 영역을 벗어나면 pass
						
						if(arr[nr][nc].equals("W")) water++ ;
					}
					
					// 주변에 물이 하나도 없다는 것은 모두 땅이었다는 것 -> 모두 땅일 경우 해당 구획의 물 깊이는 1 
					if (water == 0) water = 1 ;
					
					// 가장 깊은 물의 깊이 갱신
					max = (water > max) ? water : max ;
					
				}
			}
			
			System.out.printf("#%d %d\n", test_case, max);
			
		}
		
		sc.close() ;
		
	}

}
