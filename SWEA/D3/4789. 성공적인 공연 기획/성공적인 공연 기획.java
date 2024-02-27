import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		 // File file = new File("src/swea_4789_성공적인_공연기획/input.txt") ;
		 // Scanner sc = new Scanner(file) ;
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String str = sc.next();
			int clapPerson = 0 ;			// 박수치고 있는 사람의 수
			int totalEmployPerson = 0 ;		// 전체 고용한 인원
			
			for(int i=0; i<str.length(); i++) {
				int num = Integer.parseInt(str.substring(i, i+1)) ;
				
				if (num != 0 && clapPerson < i) {
					int employPerson = i - clapPerson ;		// 이번에 추가로 고용한 인원
					totalEmployPerson += employPerson ;		// 총 고용한 인원에 현재 고용한 인원 추가
					clapPerson += employPerson ;			// 고용한 인원을 박수치는 인원으로 추가
				} 
				
				clapPerson += num ;			// 박수치는 인원 추가
					
			}
			
			System.out.printf("#%d %d\n", test_case, totalEmployPerson);
			
		}
		
	}
}