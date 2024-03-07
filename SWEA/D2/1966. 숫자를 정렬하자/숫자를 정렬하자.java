import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1966_숫자를_정렬하자/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt() ;		// 입력받을 숫자의 개수
			int[] arr = new int [N] ;	// 숫자를 저장할 배열
			
			// 숫자 값 입력받기
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 숫자 정렬 (sort 사용x)
			for(int i=0; i<arr.length-1; i++) {
				for(int j=i; j<arr.length; j++) {
					if(arr[i] > arr[j]) {
						int temp = arr[i] ;
						arr[i] = arr[j] ;
						arr[j] = temp ;
					}
				}
			}
			
			// 숫자 하나씩 출력
			System.out.printf("#%d", test_case);
			for(int i=0; i<arr.length; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
			
		}
		
	}

}
