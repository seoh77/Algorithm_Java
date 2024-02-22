import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
	
		// File file = new File("src/swea_2007_패턴마디의길이/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;         // 테스트 케이스 개수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String str = sc.next() ;	// 문자열 입력
			
			// 첫 글자와 똑같은 문자가 있는 index를 배열에 저장
			int[] arr = new int [30] ;   // 각 문자열의 길이는 30이므로 최대 30으로 배열 크기 설정
			int saveIdx = 0 ;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(0) == str.charAt(i)) {
					arr[saveIdx++] = i ; 
				}
			}
			
			// 마디 길이 구하기
			int i = 1 ;
			int len = arr[i] ;   // 마디의 길이 
			
			while(true) {
				
				for(int l=0; l<len; l++) {
					int idx = arr[i] ;
					len = arr[i] ;
					
					if (str.charAt(l) == str.charAt(l+idx)) continue ;
					i++ ;
				}
				
				break ;
				
			}
			
			System.out.printf("#%d %d\n", test_case, len);
			
		}
		
		sc.close() ;
		
	}
}
