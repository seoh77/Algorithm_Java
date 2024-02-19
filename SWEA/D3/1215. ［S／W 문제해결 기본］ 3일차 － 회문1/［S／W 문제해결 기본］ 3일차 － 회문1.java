/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1215_회문1/input.txt") ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = 10 ;      // 테스트 케이스 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int pNum = sc.nextInt() ;     // 찾아야 하는 회문의 길이 
			int count = 0 ;               // 글자판에서 제시된 길이를 가진 회문의 개수 (출력해야 되는 값)
			
			// 8 * 8 크기의 글자판 생성 및 값 입력
			String[][] arr = new String[8][8] ;
			for (int r=0; r<arr.length; r++) {
				String[] temp = sc.next().split("") ;
				for (int c=0; c<arr[r].length; c++) {
					arr[r][c] = temp[c] ;
				}
			}
			
			// 가로로 되어있는 회문 탐색
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<=arr[r].length-pNum; c++) {
					boolean pass = true ;
					int start = c ;
					for(int last=c+pNum-1; last>=c; last--) {
						if(!arr[r][start].equals(arr[r][last])) {
							pass = false ;
							break ;
						}
						start++ ;
					}
					
					if (pass) count++ ;
				}
			}
			
			// 세로로 되어있는 회문 탐색
			for(int c=0; c<arr.length; c++) {
				for(int r=0; r<=arr.length-pNum; r++) {
					boolean pass = true ;
					int start = r ;
					for(int last=r+pNum-1; last>=r; last--) {
						if(!arr[start][c].equals(arr[last][c])) {
							pass = false ;
							break ;
						}
						start ++ ;
					}
					
					if (pass) count++ ;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, count);
			
		}
		
	}
}