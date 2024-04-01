import java.util.Scanner;

public class Main {
	
	static int M ;
	static int N ;
	static int[][] arr ;
	static boolean[][] visited ;
	
	// 델타배열
	static int[] dr = {-1, 1, 0, 0} ;
	static int[] dc = {0, 0, -1, 1} ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 개수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			M = sc.nextInt();		// 배추밭 가로길이
			N = sc.nextInt();		// 배추밭 세로길이
			int K = sc.nextInt();	// 배추가 심어져 있는 위치의 개수
			
			arr = new int [M][N] ;				// 배추밭
			visited = new boolean [M][N] ;		// 방문체크 배열
			
			// 배추 위치 입력
			for(int i=0; i<K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				arr[x][y] = 1 ;
			}
			
			int cnt = 0 ;		// 퍼져있는 개수
			
			// 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사
			for(int r=0; r<M; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] == 1 && !visited[r][c]) {
						cnt++ ;						// 인접해있는 배추들의 수
						visited[r][c] = true ;		// 방문처리
						search(r, c) ;				// 인접해있는 배추 찾기
					}
				}
			}
			
			// 출력
			System.out.println(cnt);
			
		}
		
		sc.close();
		
	}

	/**
	 * 인접해있는 배추 조사
	 * @param r
	 * @param c
	 */
	private static void search(int r, int c) {
		// 델타탐색 (상하좌우 네 방향)
		for(int d=0; d<4; d++) {
			int nr = r + dr[d] ;
			int nc = c + dc[d] ;
			
			// 배열 범위 초과일 경우 pass
			if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue ;
			
			// 배추가 없거나 이미 방문한 배열이면 pass
			if(arr[nr][nc] == 0 || visited[nr][nc]) continue ;
			
			visited[nr][nc] = true ;	// 방문처리
			search(nr, nc) ;			// 재귀 돌려서 인접해있는 다른 배추 찾기
		}
		return ;
	}

}
