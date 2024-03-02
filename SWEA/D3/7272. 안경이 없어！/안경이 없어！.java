import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_7272_안경이없어/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String isSame = "SAME" ;		// 두 문자열이 같다고 생각하면 "SAME", 다르다고 생각하면 "DIFF" 
			
			String[][] strArr = new String [2][];	// 두 개의 문자열을 하나의 배열로 관리하기 위해 2차원 배열로 생성 
			
			strArr[0] = sc.next().split("") ;	// 첫 번째 문자열 
			strArr[1] = sc.next().split("") ;	// 두 번째 문자열 
			
			// 두 문자열의 길이가 다르다면 "DIFF" 출력하고 해당 테스트 케이스는 pass 
			if (strArr[0].length != strArr[1].length) {
				System.out.printf("#%d DIFF\n", test_case);
				continue ;
			}
			
			// 문자열 길이만큼 for문을 돌리며 한 글자씩 비교 
			for(int i=0; i<strArr[0].length; i++) {
				
				int[] charArr = new int [2] ;			// 한 글자씩 구멍의 개수를 판단해서 charArr 배열에 저장 
				
				for(int r=0; r<2; r++) {
					if (strArr[r][i].equals("B")) {
						charArr[r] = 2;
					} else if (strArr[r][i].equals("A") || strArr[r][i].equals("D") || strArr[r][i].equals("O") || strArr[r][i].equals("P") || strArr[r][i].equals("Q") || strArr[r][i].equals("R")) {
						charArr[r] = 1 ;
					} else {
						charArr[r] = 0 ;
					}
				}
				
				// 구멍의 개수가 다르다면 "DIFF"로 값을 변경하고, 더 이상 탐색할 필요가 없음 
				if (charArr[0] != charArr[1]) {
					isSame = "DIFF" ;
					break ;
				}
			}
			
			System.out.printf("#%d %s\n", test_case, isSame);
			
		}
		
		sc.close() ;
		
	}

}
