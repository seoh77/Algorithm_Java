import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int N ;			// 점원의 수 
	static int B ;			// 선반의 높이
	static int[] hArr ;		// 각 점원의 키를 담은 배열
	static int min ;		// B이상의 탑의 높이 중 최솟값
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1486_장훈이의_높은_선반/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			N = sc.nextInt();
			B = sc.nextInt();
			hArr = new int [N] ;
			min = Integer.MAX_VALUE ;
			
			for(int i=0; i<N; i++) {
				hArr[i] = sc.nextInt(); 
			}
			
			combi(0, 0) ;
			
			int answer = min - B ;
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
		
		sc.close() ;
		
	}

	private static void combi(int idx, int sum) {
		// sum이 B를 초과하는 순간 종료
		if (sum >= B) {
			min = (sum < min) ? sum : min ;
			return ;
		}
		
		// idx의 범위가 N의 크기를 넘어설 경우 종료
		if(idx >= N) return ;
		
		// 해당 idx를 포함하는 경우
		combi(idx+1, sum+hArr[idx]) ;
		
		// 해당 idx를 포함하지 않는 경우
		combi(idx+1, sum) ;
	}

}