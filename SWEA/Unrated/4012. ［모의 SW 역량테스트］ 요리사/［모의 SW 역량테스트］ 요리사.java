import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int N ;
	static int[] foodA ;
	static int[] foodB ;
	static int[][] sArr ;
	static int answer ;
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_4012_요리사/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			N = sc.nextInt();			    // 식재료의 수
			foodA = new int [N/2] ;			// A음식에 들어가는 재료의 index
			foodB = new int [N/2] ;			// B음식에 들어가는 재료의 index
			sArr = new int [N][N] ;			// 재료들의 시너지 값을 담아둘 배열
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sArr[i][j] = sc.nextInt();
				}
			}
			
			answer = Integer.MAX_VALUE ;					// 두 음식 간의 맛의 차이의 최솟값
			
			combi(0, 0, 0) ;
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
		
		sc.close() ;
		
	}

	/**
	 * A음식에 들어가는 재료를 선택하기 위한 메소드
	 * @param idx
	 * @param AselNum
	 * @param BselNum
	 */
	private static void combi(int idx, int AselNum, int BselNum) {
		// A음식에 들어가는 재료를 모두 선택했다면 최솟값 구하는 메소드 실행
		if (AselNum == N/2 && BselNum == N/2) {
			sumTaste() ;
			return ;
		}
			
		// 종료조건
		if (idx >= N) return ;
		
		// idx 재료 foodA에 선택o
		if (AselNum < N/2) {
			foodA[AselNum] = idx ;
			combi(idx+1, AselNum+1, BselNum) ;
		}
		
		// idx 재료 foodA에 선택x
		if (BselNum < N/2) {
			foodB[BselNum] = idx ;
			combi(idx+1, AselNum, BselNum+1) ;
		}
	}

	/**
	 * A음식과 B음식의 맛을 계산하고, 맛 차이 계산
	 */
	private static void sumTaste() {
		
		// A음식의 시너지 합 계산
		int sumA = 0 ;
		for(int i=0; i<foodA.length; i++) {
			for(int j=0; j<foodA.length; j++) {
				sumA += sArr[foodA[i]][foodA[j]] ;
			}
		}
		
		// B음식의 시너지 합 계산
		int sumB = 0 ;
		for(int i=0; i<foodB.length; i++) {
			for(int j=0; j<foodB.length; j++) {
				sumB += sArr[foodB[i]][foodB[j]] ;
			}
		}
		
		// A음식과 B음식의 맛 차이 계산
		int gap = Math.abs(sumA-sumB) ;
		
		// 최솟값 비교해서 갱신
		answer = (gap < answer) ? gap : answer ;
		
	}

}
