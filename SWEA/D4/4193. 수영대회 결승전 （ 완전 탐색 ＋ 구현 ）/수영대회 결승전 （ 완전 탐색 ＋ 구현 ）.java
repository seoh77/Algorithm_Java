import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static class Path {
		int r, c, t ;
		
		Path(int r, int c, int t) {
			this.r = r ;
			this.c = c;
			this.t = t ;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_4193_수영대회_결승전/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();						// 수영장의 크기
			int[][] arr = new int [N][N] ;				// 수영장 배열 생성
			boolean[][] visited = new boolean [N][N] ;	// 방문배열
			
			// 수영장 정보 입력
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt() ;
				}
			}
			
			// 출발점과 도착점 입력
			Path start = new Path(sc.nextInt(), sc.nextInt(), 0) ;
			Path end = new Path(sc.nextInt(), sc.nextInt(), 0) ;
			
			// 출발지점을 큐에 넣고, 방문체크
			Queue<Path> queue = new LinkedList<Path>() ;
			queue.add(start) ;
			visited[start.r][start.c] = true ;
			
			// 델타탐색
			int[] dr = {-1, 1, 0, 0} ;
			int[] dc = {0, 0, -1, 1} ;
			
			int answer = -1 ;
			
			while(!queue.isEmpty()) {
				Path now = queue.poll() ;
				int r = now.r ;
				int c = now.c ;
				int t = now.t ;
				
				// 도착지점에 온 경우
				if(r == end.r && c == end.c) {
					answer = t ;
					break ;
				}
				
				for(int d=0; d<4; d++) {
					int nr = r + dr[d] ;
					int nc = c + dc[d] ;
					
					// 범위 벗어나는 경우 pass
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue ;
					
					// 장애물이 있거나 이미 방문한 곳이면 pass
					if(arr[nr][nc] == 1 || visited[nr][nc]) continue ;
					
					// 지나갈 수 있는 곳인 경우
					if(arr[nr][nc] == 0) {
						queue.add(new Path(nr, nc, t+1)) ;
						visited[nr][nc] = true ;
					}
					
					// 소용돌이를 만나는 경우
					else if (arr[nr][nc] == 2) {
						// 소용돌이가 사라진 시간이면 그냥 지나갈 수 있음
						if(t % 3 == 2) {
							queue.add(new Path(nr, nc, t+1)) ;
							visited[nr][nc] = true ;
						}
						// 소용돌이가 있으면 사라질 때까지 기다려야 함
						else {
							queue.add(new Path(r, c, t+1)) ;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
		
		sc.close();
		
	}

}
