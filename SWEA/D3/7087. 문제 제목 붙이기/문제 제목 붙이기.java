import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_7087_문제제목붙이기/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();		// 은기가 만든 제목의 수 (입력받을 제목의 개수)
			int[] arr = new int [26] ;	// 해당 알파벳이 맨 앞 글자로 나온 횟수 (arr[0]이 'A'가 맨 앞 글자로 나온 횟수)
			
			// 문자 입력 -> 맨 앞 글자 추출 -> arr 배열에 해당 index의 값 + 1
			for(int n=0; n<N; n++) {
				String str = sc.next(); 	// 문자 입력
				char c = str.charAt(0);		// 만 앞 글자 추출 
				arr[(int)c-'A']++ ;			// arr 배열에 해당 index의 값 + 1
			}
			
			int answer = 0 ;		// 최대 문제 제목의 개수
			
			for(int i=0; i<arr.length; i++) {
				// 특정 알파벳이 문제 제목의 맨 앞글자로 등장하지 않으면 그 이후 알파벳은 사용하지 않음 
				if (arr[i] == 0) break ;
				
				answer++ ;
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
		
		sc.close(); 
		
	}

}
