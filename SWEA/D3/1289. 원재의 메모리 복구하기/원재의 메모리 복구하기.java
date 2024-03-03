import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1289_원재의_메모리복구하기/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String str = sc.next();		// 메모리의 원래 값 입력 받기
			char type = '0' ;			// 현재 메모리 bit에 적힌 값 (초기화 상태는 모든 bit가 0인 상태이므로 초기값으로 0 설정)
			int fix = 0 ;			// 고쳐야 하는 횟수 
			
			// str 크기만큼 for문을 돌면서 type과 다를 때 고쳐야 하는 횟수 + 1 
			for(int i=0; i<str.length(); i++) {
				if (str.charAt(i) != type) {
					fix++ ;									// 고치는 횟수 + 1
					type = (type == '0' ? '1' : '0') ;		// type 값 변경 
				}
			}
			
			System.out.printf("#%d %d\n", test_case, fix);
			
		}
		
		sc.close() ;
		
	}

}
