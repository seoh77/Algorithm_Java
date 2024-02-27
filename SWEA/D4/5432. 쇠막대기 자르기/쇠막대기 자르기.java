import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_5432_쇠막대기_자르기/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String[] str = sc.next().split("");		// 쇠막대기와 레이저 배치를 나타내는 괄호 표현
			
			int answer = 0 ;		// 잘려진 쇠막대기 조각의 총 개수
			int row = 0 ;			// 현재 쇠막대기 개수
			int idx = 0 ;
			
			while(idx < str.length) {
				if (str[idx].equals("(")) {
					// "("와 ")"가 연달아 나오면 레이저
					if (str[idx+1].equals(")")) {
						answer += row ;
						idx +=2  ;			// 다음 인덱스를 확인할 필요가 없음
						continue ;
					}
					row ++ ;	// "("만 나오면 쇠막대기의 왼쪽 끝
				} else if (str[idx].equals(")")) {		// 쇠막대기의 오른쪽 끝
					answer ++ ;
					row -- ;
				}
				idx++ ;		// 다음 인덱스 탐색
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
		
		sc.close(); 
		
	}

}
