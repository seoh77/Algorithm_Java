import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N ; 					// 정점의 수
	static int[][] adj ;			// 인접행렬 
	static boolean[] visited ;		// 방문체크
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		N = sc.nextInt();				// 정점의 개수
		int M = sc.nextInt();			// 간선의 개수
		int V = sc.nextInt();			// 탐색을 시작할 정점의 번호

		adj = new int [N+1][N+1] ;		// 인접행렬 생성
		
		// 인접 행렬 정보 입력
		for(int i=0; i<M; i++) {
			int a = sc.nextInt() ;
			int b = sc.nextInt() ;
			
			adj[a][b] = adj[b][a] = 1 ;
		}

		// DFS
		visited = new boolean[N+1] ;		// 방문 체크 배열 초기화
		DFS(V) ;
		
		System.out.println();
		
		// BFS
		visited = new boolean[N+1] ;		// 방문 체크 배열 초기화
		BFS(V) ;
		
		sc.close();
		
	}

	private static void DFS(int v) {
		// v 방문처리
		visited[v] = true ;
		System.out.print(v + " ");
		
		// 인접한 요소 방문
		for(int i=1; i<=N; i++) {
			if (!visited[i] && adj[v][i] == 1) {
				DFS(i) ;
			}
		}
	}

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>() ;
		
		queue.add(v) ;
		visited[v] = true ;
		
		// 큐가 공백상태가 될 때까지 반복문 수행
		while(!queue.isEmpty()) {
			int curr = queue.poll() ;
			System.out.print(curr + " ");
			
			for(int i=1; i<=N; i++) {
				if (!visited[i] && adj[curr][i] == 1) {
					queue.add(i) ;
					visited[i] = true ;
				}
			}
		}
		
	}

	
}
