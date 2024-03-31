import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Coord {
		int f, r, c ;
		
		Coord(int f, int r, int c) {
			this.f = f ;
			this.r = r ;
			this.c = c ;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int m = sc.nextInt();		// 상자의 가로 칸의 수
		int n = sc.nextInt();		// 상자의 세로 칸의 수 
		int h = sc.nextInt();		// 쌓여올려지는 상자의 수
		
		int[][][] arr = new int [h][n][m] ;		// 상자 배열
		
		Queue<Coord> queue = new LinkedList<Coord>() ;		// 큐 생성
		
		int cnt = 0 ;				// 익은 토마토 수 
		int total = m * n * h ;		// 상자에 있는 모든 토마토 수 
		
		// 토마토 정보 입력 (1: 익은 토마토, 0 : 익지 않은 토마토, -1: 토마토가 들어있지 않음)
		for(int f=0; f<h; f++) {
			for(int r=0; r<n; r++) {
				for(int c=0; c<m; c++) {
					int tomato = sc.nextInt();
					arr[f][r][c] = tomato ;
					
					if(tomato == 1) {
						cnt++ ;
						queue.add(new Coord(f, r, c)) ;
					} else if (tomato == -1) {
						total -- ;
					}
				}
			}
		}
		
		int day = 0;		// 모든 토마토가 익을 때까지 걸리는 날짜
		
		// 델타배열
		int[] df = {-1, 1, 0, 0, 0, 0} ;
		int[] dr = {0, 0, -1, 1, 0, 0} ;
		int[] dc = {0, 0, 0, 0, -1, 1} ;
		
		// 큐가 빌 떄까지 반복
		// 상자에 있는 모든 토마토가 다 익었다면 (cnt == total) 굳이 반복문을 수행할 필요가 없음
		while(!queue.isEmpty() && cnt != total) {
			// 큐에 저장되어있는 토마토 꺼내기
			Coord coord = queue.poll() ;
			int f = coord.f ;
			int r = coord.r ;
			int c = coord.c ;
			
			// 인접한 토마토 중 아직 익지 않은 토마토의 상태 변경
			for(int d=0; d<6; d++) {
				int nf = f + df[d] ;
				int nr = r + dr[d] ;
				int nc = c + dc[d] ;
				
				if (nf < 0 || nf >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue ;
				if(arr[nf][nr][nc] != 0) continue ;
				
				arr[nf][nr][nc] = arr[f][r][c] + 1;
				cnt++ ;		// 익은 토마토 개수 증가
				queue.add(new Coord(nf, nr, nc)) ;
				
				// 날짜 값 갱신
				day = arr[nf][nr][nc] - 1;
			}
		}
		
		// 큐가 비었음에도 상자에 있는 모든 토마토가 비어있지 않다면 토마토가 모두 익지 못하는 상황
		if (cnt != total) {
			day = -1 ;
		}
		
		// 출력
		System.out.println(day);
		
		sc.close();
		
	}

}
