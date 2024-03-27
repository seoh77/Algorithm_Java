import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int[] rootArr ;
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_7465_창용마을_무리의_개수/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt(); 		// 창용 마을에 사는 사람의 수
			
			// rootArr 초기값 설정
			rootArr = new int [N+1];
			for(int i=1; i<N+1; i++) {
				rootArr[i] = i ;
			}
			
			int M = sc.nextInt();		// 서로 알고 있는 사람의 관계 수
			
			// 서로 알고 있는 관계 입력
			for(int i=0; i<M; i++) {
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				
				union(p1, p2) ;
			}
			
			int cnt = 0 ;			// 존재하는 무리의 개수
			
			// 자기 자신이 루트라면 cnt++
			for(int i=1; i<=N; i++) {
				if (i == rootArr[i]) cnt++ ;
			}
			
			// 출력
			System.out.printf("#%d %d\n", test_case, cnt);
			
		}
		
		sc.close();
		
	}

	private static void union(int p1, int p2) {
		rootArr[findset(p2)] = findset(p1) ;
	}

	private static int findset(int x) {
		if (x == rootArr[x]) return x ;
		return findset(rootArr[x]) ;
	}

}
