import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());		// 정점의 개수
		int m = Integer.parseInt(st.nextToken());		// 간선의 개수
		
		arr = new int [n+1][n+1];	// 연결되어 있는 정점을 관리하기 위한 배열
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());	// 간선의 양 끝 점
			
			arr[u][v] = arr[v][u] = 1;
		}
		
		visited = new boolean [n+1];	// 방문체크를 위한 배열
		answer = 0;

		// 연결 요소 개수 확인
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			
			answer++;
			dfs(i);
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int idx) {
		for(int i=1; i<=n; i++) {
			if(arr[idx][i] == 0 || visited[i]) continue;
			
			visited[i] = true;
			dfs(i);
		}
	}
}
