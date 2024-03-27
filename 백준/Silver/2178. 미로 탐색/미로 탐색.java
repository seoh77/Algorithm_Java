import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	// x, y 좌표를 함께 기록하기 위해 Pair 클래스 생성
	static class Pair {
		int x, y ;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int [N+1][M+1];					// N * M 크기의 미로 -> 시작을 (1,1)로 맞추기 위해 [N+1][M+1]로 배열 생성
		boolean[][] visited = new boolean [N+1][M+1] ;		// 방문했는지 여부를 체크할 배열
		
		// 미로 정보 입력 (1 : 이동할 수 있는 칸 , 0 : 이동할 수 없는 칸)
		for(int i=1; i<=N; i++) {
			String[] str = sc.next().split("") ;
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]) ;
			}
		}
		
		Queue<Pair> queue = new LinkedList<Pair>() ;
		
		queue.add(new Pair(1,1)) ;			// 시작 좌표(1,1) queue에 넣기
		visited[1][1] = true ;				// 시작 좌표(1,1) 방문했다고 표시
		
		// 델타배열 설정
		int[] dr = {-1, 1, 0, 0} ;
		int[] dc = {0, 0, -1, 1} ;
		
		while(!queue.isEmpty()) {
			// queue에서 현재 좌표 꺼내기
			Pair p = queue.poll() ;
			
			// 4방 탐색
			for(int d=0; d<4; d++) {
				int nx = p.x + dr[d] ;
				int ny = p.y + dc[d] ;
				
				// 미로의 크기를 벗어나면 pass 
				if (nx <= 0 || nx > N || ny <= 0 || ny > M) continue ;
				
				// 이미 방문했거나 이동할 수 없는 칸이라면 pass 
				if (visited[nx][ny] || arr[nx][ny] == 0) continue ;
				
				queue.add(new Pair(nx, ny)) ;		// 큐에 이동한 좌표 넣어주기
				visited[nx][ny] = true ;			// 이동한 좌표 방문했다고 표시 
				arr[nx][ny] = arr[p.x][p.y] + 1;	// 한 칸 이동하였기 때문에, 이전 출발지점의 거리 + 1
			}
		}
		
		// 도착지점(N, M)의 값 출력
		System.out.println(arr[N][M]);
		
		sc.close();
		
	}

}
