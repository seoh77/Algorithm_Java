import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_4613_러시아국기같은깃발/input.txt") ;
		// Scanner sc = new Scanner(file) ;
        Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt() ;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();     			// N행 
			int M = sc.nextInt(); 				// M열 
			String[][] arr = new String [N][M] ;		// 깃발 배열
			
			// 현재 색깔 입력받기 
			for(int r=0; r<arr.length; r++) {
				String str = sc.next() ;
				for(int c=0; c<arr[r].length; c++) {
					arr[r] = str.split("") ;
				}
			}
			
			int min = Integer.MAX_VALUE ;
			
			// 새로 칠해야 하는 칸을 계산
			// 0 ~ blueStart : 흰색 , blueStart ~ blueEnd : 파란색 , blueEnd ~ arr.length : 빨간색 
			for(int blueStart=1; blueStart<arr.length-1; blueStart++) {
				for(int blueEnd=1; blueEnd<arr.length-1; blueEnd++) {
					int paintNum = paint(arr, blueStart, blueEnd) ;
					min = (paintNum < min) ? paintNum : min ;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, min);
		}
		
		sc.close();
		
	}
	
	/**
	 * 새로 칠해야 하는 칸을 계산하기 위한 메소드 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int paint(String[][]arr , int start, int end) {
		
		int paintNum = 0 ;		// 새로 칠해야 하는 칸을 개수를 계산하기 위한 변수
		
		// 흰색 부분 
		for(int r=0; r<start; r++) {
			for(int c=0; c<arr[r].length; c++) {
				if (!arr[r][c].equals("W")) paintNum++ ;
			}
		}
		
		// 파란색 부분
		for(int r=start; r<=end; r++) {
			for(int c=0; c<arr[r].length; c++) {
				if (!arr[r][c].equals("B")) paintNum++ ;
			}
		}
		
		// 빨간색 부분 
		for(int r=end+1; r<arr.length; r++) {
			for(int c=0; c<arr[r].length; c++) {
				if(!arr[r][c].equals("R")) paintNum++ ;
			}
		}
		
		return paintNum ;
	}

}
