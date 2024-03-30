import java.util.Scanner;

public class Main {
	
	static int[][] adj ;
	static boolean[] visited ;
	static int answer ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();			// 컴퓨터 수
		int m = sc.nextInt();			// 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
		
		adj = new int [n+1][n+1] ;			// 네트워크상에서 직접 연결되어 있는 컴퓨터의 번호 쌍 저장 
		visited = new boolean[n+1] ;		// 방문한 컴퓨터를 체크하기 위한 배열
		
		// 직접 연결되어 있는 컴퓨터 정보 입력 받기
		for(int i=0; i<m; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			adj[num1][num2] = adj[num2][num1] = 1 ;
		}
		
		answer = 0 ;	// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터 수
		
		DFS(1) ;		// 1번 컴퓨터부터 시작
		
		System.out.println(answer);
		
		sc.close();
		
	}

	private static void DFS(int idx) {
		visited[idx] = true ;		// 방문표시 
		
		for(int i=1; i<adj.length; i++) {
			if(!visited[i] && adj[idx][i] == 1) {	// 방문하지 않았고, idx와 직접 연결되어 있는 컴퓨터
				answer++ ;		// 바이러스에 걸리게 되는 컴퓨터 수 1증가 (1번 컴퓨터는 포함되면 안되기 때문에 for문 내부에 작성)
				DFS(i) ;		// 해당 컴퓨터를 기준으로 직접 연결되어 있는 다른 컴퓨터 찾기
			}
		}
	}

}
