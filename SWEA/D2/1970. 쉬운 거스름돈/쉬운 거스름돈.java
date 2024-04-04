import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
//		File file = new File("src/swea_1970_쉬운_거스름돈/input.txt") ;
//		Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int money = sc.nextInt();					 // 손님에게 거슬러 주어야 할 금액
			int[] type = {50000, 10000, 5000, 1000, 500, 100, 50, 10} ;	 // 돈의 종류
			int[] cnt = new int [type.length] ;
			
			for(int t=0; t<type.length; t++) {
				cnt[t] = money / type[t] ;
				money = money % type[t] ;
			}
			
			// 출력
			System.out.println("#" + test_case);
			
			for(int i=0; i<cnt.length; i++) { 
				System.out.print(cnt[i]+" ");
			}
			System.out.println();
			
		}
		
		sc.close();
		
	}

}
