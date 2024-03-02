import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		 // File file = new File("src/swea_1860_진기의_최고급붕어빵/input.txt") ;
		 // Scanner sc = new Scanner(file) ;
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();		// 몇 명의 사람들이 구매하러 오는지 
			int M = sc.nextInt();		// M초의 시간을 들이면 
			int K = sc.nextInt();		// K개의 붕어빵을 만들 수 있음 
			
			int[] arr = new int [11112] ;	// 몇 초(indx 값)에 몇 명(요소 값)이 오는지 담아두는 배열 (0이상 11,111 이하)
			
			// 손님이 언제 도착하는지 입력받아서 arr 배열에 기록
			for(int i=0; i<N; i++) {
				arr[sc.nextInt()]++ ;
			}
			
			// 모든 손님에 대해 기다리는 시간이 없이 붕어빵을 제공할 수 있는지 판별
			String answer = "Possible" ;
			int num = 0;		// 붕어빵 개수 
			
			for(int time=0; time<arr.length; time++) {
				
				// 붕어빵이 나오는 시간(M초마다)에는 K개의 붕어빵 추가
				if (time != 0 && time % M == 0)	num += K ;
				
				if (arr[time] == 0) continue ;		// 구매할 손님이 없을 때는 굳이 아래 단계 진행 X
				
				// 손님이 오면 붕어빵 구매
				num -= arr[time] ;
				
				// 만약에 붕어빵 개수가 부족하면 "Impossible"로 변경하고, 반복문 종료 
				if (num < 0) {
					answer = "Impossible" ;
					break ;
				}
			}
			
			System.out.printf("#%d %s\n", test_case, answer);
			
		}
		
		sc.close() ;
		
	}

}
