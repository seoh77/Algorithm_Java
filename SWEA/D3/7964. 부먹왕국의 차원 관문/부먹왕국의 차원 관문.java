import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_7964_부먹왕국의_차원관문/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수 
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();		// 부먹 왕국의 도시 수
			int D = sc.nextInt();		// 이동 제한 거리
			
			int[] city = new int [N+2] ;	// 도시 배열 (0번 위치와 N+1 위치도 고려하기 위해 크기를 N+2로 설정
			
			city[0] = 1;
			city[city.length-1] = 1 ;		// 0번 위치와 N+1번 위치에는 차원 관문이 존재한다고 문제에서 제시
			
			// 각 도시에 차원관문이 남아있는지 정보 입력받기 (1 : 남아있음 , 0 : 파괴됨)
			for(int i=1; i<city.length-1; i++) {
				city[i] = sc.nextInt() ;
			}
			
			int fix = 0 ;		// 추가로 건설해야 하는 차원관문의 수
			int cnt = 0 ;		// 망가진 차원관문의 수
			int idx = 0 ;		// 가장 마지막으로 차원관문이 있는 도시의 index 번호 
			
			for(int i=0; i<city.length; i++) {
				// 차원관문이 남아있는 경우 
				if (city[i] == 1) {
					idx = i ;
					cnt = 0 ;		// 망가진 차원관문의 수 초기화
					continue ;
				} 
				
				// 차원관문이 파괴된 경우
				if(city[i] == 0) {		
					cnt ++ ;		// 망가진 차원관문의 수 + 1 
				}
				
				// 망가진 차원관문의 수가 D와 같아질 경우 차원관문 하나 추가 건설
				if(cnt == D) {
					fix++ ;
					cnt = 0 ;		// 망가진 차원관문의 수 초기화
				}
			}
			
			System.out.printf("#%d %d\n", test_case, fix);
			
		}
		
		sc.close() ;
		
	}

}
