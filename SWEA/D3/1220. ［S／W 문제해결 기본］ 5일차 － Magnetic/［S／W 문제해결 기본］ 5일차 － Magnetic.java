import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1220_Magnetic/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = 10 ;		// 총 10개의 테스트 케이스 
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt() ;				// 정사각형 테이블의 한 변의 길이 (항상 100으로 고정)
			int[][] table = new int [N][N] ;	// 테이블의 초기 모습을 담아둘 배열
		
			// 테이블의 초기 모습 입력  (1 : N극 성질을 가지는 자성체 , 2 : S극 성질을 가지는 자성체) 
			for(int r=0; r<table.length; r++) {
				for(int c=0; c<table[r].length; c++) {
					table[r][c] = sc.nextInt();
				}
			}
			
			int num = 0 ;		// 교착상태의 개수 계산 
			
			for(int c=0; c<table.length; c++) {
                // 각 열을 기준으로 1, 2만으로 이루어진 String 생성 
				String str = "" ;
 				for(int r=0; r<table.length; r++) {
 					if(table[r][c] == 0) continue ;
 					str += table[r][c] ;
 				}
                // 위에서 만든 String에서 "12"의 개수 세서 num++
 				for(int i=0; i<str.length()-1; i++) {
 					if(str.charAt(i) == '1' && str.charAt(i+1) == '2') num++ ;
 				}
			}
			
			System.out.printf("#%d %d\n", test_case, num);
			
		}
		
		sc.close(); 
		
	}

}
