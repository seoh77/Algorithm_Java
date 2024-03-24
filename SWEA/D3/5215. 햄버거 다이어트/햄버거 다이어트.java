import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int N ;			// 재료의 수
	static int L ;			// 제한 칼로리
	static int[] taste ;	// 민기의 맛에 대한 점수
	static int[] kcal ;		// 각 재료에 대한 칼로리
	static int maxTaste ;	// 민기가 가장 선호하는 햄버거의 점수
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_5215_햄버거_다이어트/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
        
		int T = sc.nextInt() ;			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			// 각 정보 입력받기
			N = sc.nextInt();
			L = sc.nextInt();
			taste = new int [N] ;
			kcal =  new int [N] ;
			for(int i=0; i<N; i++) {
				taste[i] = sc.nextInt();
				kcal[i] = sc.nextInt(); 
			}
			maxTaste = 0 ;
			
			combi(0, 0 , 0) ;
			
			System.out.printf("#%d %d\n", test_case, maxTaste);
		}
		
		sc.close();
		
	}
	
	public static void combi(int idx, int curKcal, int curTaste) {
		// 종료조건
		if(curKcal >= L || idx >= taste.length) {
			// 최댓값 갱신되는지 확인
			maxTaste = (curTaste > maxTaste) ? curTaste : maxTaste ;
			return ;
		}
		
		// 현재의 idx 요소를 넣지 않는 경우
		combi(idx+1, curKcal, curTaste) ;
		
		// 현재의 idx 요소를 넣는 경우 (단, curKcal+kcal[idx]가 제한칼로리 이하여야 한다)
		if (curKcal+kcal[idx] <= L) {
			combi(idx+1, curKcal+kcal[idx], curTaste+taste[idx]) ;
		}
	}

}
