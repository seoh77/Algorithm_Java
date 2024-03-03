import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_1493_수의_새로운_연산/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();		// 테스트 케이스의 수
		
		// 2차원 평면 제1사분면 위의 격자점 (x,y)에 대각선 순서로 점에 수를 붙임 
		int[][] arr = new int [301][301] ;		// -> 계속 index 에러 떠서 댓글 참고해서 300으로 설정했더니 해결
		int cnt = 0 ;	
		int idx = 1 ;
		
		// 절반 채우기 
		while (idx <= 300) {
			int r = idx ;
			int c = 1 ;
			for(int i=idx; i>=1; i--) {
				arr[r--][c++] = ++cnt ;
			}
			idx++ ;
		}
		
		// 나머지 절반 채우기
		cnt = 300*300 ;
		idx = 300 ;
		
		while(idx <= 300 && idx >= 0) {
			int r = arr.length-1 ;
			int c = idx ;
			for(int i=idx; i<arr.length; i++) {
				arr[r--][c++] = cnt-- ;
			}
			idx-- ;
		}
		
		for(int test_case=1; test_case<=T; test_case++) {
			int p = sc.nextInt() ;
			int q = sc.nextInt() ;
			
			// p와 q의 좌표값을 저장할 배열 
			int[] pArr = new int [2] ;
			int[] qArr = new int [2] ;
			
			for(int r=1; r<arr.length; r++) {
				for(int c=1; c<arr.length; c++) {
					if (arr[r][c] == p) {
						pArr[0] = r ;
						pArr[1] = c ;
					}
					if (arr[r][c] == q) {
						qArr[0] = r ;
						qArr[1] = c ;
					}
					if(pArr[0] != 0 & qArr[0] != 0) break ;
				}
			}
			
			// 두 좌표 더하기 
			int[] pqArr = {pArr[0]+qArr[0], pArr[1]+qArr[1]} ;
			
			// 두 좌표에 할당된 점 구하기
			int answer = arr[pqArr[0]][pqArr[1]] ;
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
		
		sc.close() ;
		
	}

}
