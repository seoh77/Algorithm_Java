import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
	
		// File file = new File("src/swea_4047_영준이의_카드카운팅/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;			// 테스트 케이스의 개수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String str = sc.next();		// 현재 가지고 있는 카드에 대한 정보 (3자리로 표현)
			
			int[][] arr = new int [4][14] ;		// 카드 덱 배열
			
			for(int i=0; i<str.length(); i+=3) {
				char c = str.charAt(i) ;	// 카드의 무늬
				int num = Integer.parseInt(str.substring(i+1, i+3)) ;	// 카드의 숫자
				
				// 주어진 카드 각 배열에 집어넣기
				if (c == 'S') {
					arr[0][num]++ ;
				} else if (c == 'D') {
					arr[1][num]++ ;
				} else if (c == 'H') {
					arr[2][num]++ ;
				} else if (c == 'C') {
					arr[3][num]++ ;
				}
			}
			
			boolean isError = false; 
			int[] addCardArr = new int [4] ;
			for(int r=0; r<arr.length; r++) {
				for(int c=1; c<arr[r].length; c++) {
					if (arr[r][c] >= 2) {
						isError = true ;
						break ;
					} else if (arr[r][c] == 0) addCardArr[r]++ ;
				}
			}
			
			// 이미 겹치는 카드가 있다면 "ERROR"
			if (isError) {
				System.out.printf("#%d ERROR\n", test_case);
				continue ;
			}
			
			// 몇 장의 카드가 더 필요한지 계산
			System.out.printf("#%d", test_case);
			for(int i=0; i<addCardArr.length; i++) {
				System.out.print(" "+addCardArr[i]);
			}
			System.out.println();
		}
		
	}
}
