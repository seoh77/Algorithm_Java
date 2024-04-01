import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1267_작업순서/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = 10;		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int V = sc.nextInt();		// 정점의 개수
			int E = sc.nextInt();		// 간선의 개수
			
			int[] arr = new int [V+1] ;				   // 선행해야 되는 작업의 수를 담고있는 배열
			int[][] adj = new int [V+1][V+1] ;		// 인접행렬
			
			// 간선 정보 입력
			for(int i=0; i<E; i++ ) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adj[a][b] = 1 ;			// 인접 체크
				arr[b]++ ;				// 선행해야 되는 작업 수 1 증가
			}
			
			Queue<Integer> queue = new LinkedList<Integer>() ;
			
			// arr[idx] = 0인 위치 찾아서 큐에 넣기 
			for(int i=1; i<=V; i++) {
				if (arr[i] == 0) {
					queue.add(i) ;
				}
			}
			
			StringBuilder sb = new StringBuilder() ;
			sb.append("#"+test_case) ;
			
			// 큐가 공백이 될 때까지 반복
			while(!queue.isEmpty()) {
				int idx = queue.poll() ;
				sb.append(" " + idx) ;
				
				for(int i=1; i<=V; i++) {
					// 인접된 요소
					if(adj[idx][i] == 1) {
						arr[i]-- ;				   // 선행해야 되는 작업수 -1
						adj[idx][i] = 0 ;		// 연결 끊기
						
						// 모두 다 선행되었으면 큐에 넣기
						if(arr[i] == 0) {
							queue.add(i) ;
						}
					}
				}
			}
			
			// 출력
			System.out.println(sb);
		}
		
		sc.close();
		
	}

}
