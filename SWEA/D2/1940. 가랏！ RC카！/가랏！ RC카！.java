import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1940_가랏RC카/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;       // 총 테스트 케이스의 개수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt() ;       // Command의 수
			int total = 0 ;              // 총 거리
			int current = 0 ;			 // 현재 속도
			
			for(int n=0; n<N; n++) {
				int command = sc.nextInt() ;   // command (0: 현재 속도 유지, 1: 가속, 2: 감속)
				
				if(command == 1) {
					current += sc.nextInt() ;
				} else if (command == 2) {
					int inputValue = sc.nextInt() ; 
					if (inputValue > current) inputValue = 0 ;    // 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0
					current -= inputValue ;
				}
				
				total += current ;
			}
			
			System.out.printf("#%d %d\n", test_case, total);
			
		}
		
	}

}
