import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Path{
		int r, c;
		
		Path(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 캠퍼스 크기 N * M
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[][] campus = new String [n][m];

		Queue<Path> queue = new LinkedList<Path>();
		
		for(int r=0; r<n; r++) {
			String[] arr = br.readLine().split("");
			for(int c=0; c<m; c++) {
				campus[r][c] = arr[c];
				
				if(arr[c].equals("I")) {
					queue.add(new Path(r, c));
				}
			}
		}
		
		boolean[][] visited = new boolean [n][m];
		int answer = 0;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		
		while(!queue.isEmpty()) {
			Path path = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = path.r + dr[d];
				int nc = path.c + dc[d];
				
				// 캠퍼스 크기를 벗어낫거나 이미 방문했던 곳이라면 pass
				if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
				
				// 벽이라면 이동할 수 없으므로 pass
				if(campus[nr][nc].equals("X")) continue;

				// 사람을 만났다면 answer + 1
				if(campus[nr][nc].equals("P")) answer++;
				
				queue.add(new Path(nr, nc));
				visited[nr][nc] = true;
				
			}
		}
		
		if(answer == 0) {
			System.out.println("TT");
		} else {
			System.out.println(answer);
		}
		
	}
}
