import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1251_하나로/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt(); 					// 섬의 개수
			long[] xArr = new long [N] ;		// 각 섬들의 X좌표를 담아둘 배열
			long[] yArr = new long [N] ;		// 각 섬들의 y좌표를 담아둘 배열
			
			// x좌표 입력
			for(int i=0; i<N; i++) {
				xArr[i] = sc.nextInt(); 
			}
			
			// y좌표 입력
			for(int i=0; i<N; i++) {
				yArr[i] = sc.nextInt();	
			}
			
			double E = sc.nextDouble();		// 환경 부담 세율
	
			long[][] adjArr = new long [N][N];	// 인접행렬 
			
			// 섬들간의 거리 계산
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (i == j) continue ;
					
					// 두 점 사이의 거리 구하는 공식
					long d = ((xArr[j]-xArr[i]) * (xArr[j]-xArr[i])) + ((yArr[j]-yArr[i]) * (yArr[j]-yArr[i])) ;
					adjArr[i][j] = adjArr[j][i] = d ;	
				}
			}
			
			boolean[] visited = new boolean [N] ;		// 방문처리를 위한 배열 
			
			// dist 초기화
			long[] dist = new long [N] ;
			for(int i=0; i<N; i++) {
				dist[i] = Long.MAX_VALUE ;
			}
			
			// 0번 섬부터 시작
			dist[0] = 0 ;
			
			// 다른 섬 선택
			for(int i=0; i<N-1; i++) {
				long min = Long.MAX_VALUE ;
				int idx = -1 ;
				
				// 아직 안 뽑힌 섬들 중 거리가 가장 가까운 섬
				for(int j=0; j<N; j++) {
					if(!visited[j] && dist[j] < min) {
						min = dist[j] ;
						idx = j;
					}
				}
				
				visited[idx] = true ;		// 방문처리
				
                // 이전 정점과의 거리보다 새로 뽑힌 정점과 더 가까운 게 있다면 갱신
				for(int j=0; j<N; j++) {
					if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
						dist[j] = adjArr[idx][j] ;
					}
				}
			}
			
			double answer = 0 ;		// 환경 부담금 (최소)
			
            // 환경 부담금 계산
			for(int i=0; i<N; i++) {
				answer += (E * dist[i]) ;
			}
			
			System.out.printf("#%d %d\n", test_case, Math.round(answer));
			
		}
		
		sc.close() ;
		
	}

}
