import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
//		File file = new File("src/swea_1238_Contact/input.txt") ;
//		Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = 10 ;			// 테스트 케이스 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int len = sc.nextInt();			// 입력받는 데이터의 길이
			int start = sc.nextInt();		// 시작점
			
			int[] arr = new int [101] ;				// 해당 인덱스에는 몇 번째로 연락이 닿는지 저장
			int[][] adj = new int [101][101] ;		// 인접행렬
			
			// 인접 체크
			for(int i=1; i<=len/2; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adj[a][b] = 1 ; 
			}
			
			// 큐 생성
			Queue<Integer> queue = new LinkedList<Integer>() ;
			
			arr[start] = 1;				// 시작지점에 1 대입 (방문 체크로도 활용)
			queue.add(start) ;			// 시작지점 큐에 넣기 
			
			int time = 0;				// 총 몇 번 연락이 이어지는지 체크
			
			// 큐가 빌 때까지 반복
			while(!queue.isEmpty()) {
				int idx = queue.poll() ;		// 큐에서 값 하나 꺼내기
				
				// 모든 요소를 순회하면서
				for(int i=1; i<101; i++) {
					// idx로부터 이어져있고, 아직 방문하지 않은 요소 찾기
					if (adj[idx][i] == 1 && arr[i] == 0) {
						queue.add(i) ;				// 큐에 대입
						arr[i] = arr[idx]+1 ;		// arr[i] = arr[idx]+1 로 값 수정
						time = arr[i] ;				// 몇 번째 연락인지 값 수정
					}
				}
			}
			
			// 마지막에 동시에 연락을 받은 사람 중 가장 큰 번호의 사람 찾기
			int max = 0 ;
			for(int i=1; i<101; i++) {
				if (arr[i] == time) {
					max = (i > max) ? i : max ;
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", test_case, max);
			
		}
		
		sc.close();
		
	}

}
