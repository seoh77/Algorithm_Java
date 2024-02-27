import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_5356_의석이의_세로로말해요/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String[][] arr = new String [5][15] ;		// 5개의 단어들을 담아둘 배열  (문자열 길이 : 1이상 15 이하)
			
			for(int r=0; r<arr.length; r++) {
				String[] charArr = sc.next().split("") ;		// 단어 1개 입력받아서 한 자리씩 자르기
				for(int c=0; c<charArr.length; c++) {	
					arr[r][c] = charArr[c] ;			// 단어들을 담아두는 배열에 넣기
				}
			}
			
			String str = "" ;		// 세로로 읽은 순서대로 글자를 저장할 변수
			
			// 세로로 읽기
			for(int c=0; c<15; c++) {
				for(int r=0; r<5; r++) {
					if (arr[r][c] == null) continue ;
					str += arr[r][c] ; 
				}
			}
			
			System.out.printf("#%d %s\n", test_case, str);
			
		}
		
		sc.close() ;
		
	}

}
