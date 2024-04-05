import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int D ;		// 보호필름의 두께
	static int W ;		// 가로 크기
	static int K ;		// 합격기준
	
	static int[][] arr ;	// 각 셀들의 특성을 담고있는 배열
	static int[][] copy ;	// arr 배열 복사본
	
	static int min ;		//  약품의 최소 투입 횟수
	
	public static void main(String[] args) throws Exception {
		
//		File file = new File("src/swea_2112_보호필름/input.txt") ;
//		Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();			// 테스트 케이스 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			D = sc.nextInt();			// 보호필름의 두께
			W = sc.nextInt();			// 가로 크기
			K = sc.nextInt();			// 합격기준
			
			arr = new int [D][W] ;		// 각 셀들의 특성을 담고있는 배열
			copy = new int [D][W] ;		// arr 배열의 복사본
			
			// 약품의 최소 투입 횟수
			// K번 약품을 투입하면 무조건 합격기준을 충족시킬 수 있으므로 초기값을 K로 설정
			min = K ;	
			
			// 각 셀들의 특성 입력 (특성A = 0 , 특성B = 1)
			for(int r=0; r<D; r++) {
				for(int c=0; c<W; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			// arr 배열 copy 배열에 복사
			for(int r=0; r<D; r++) {
				for(int c=0; c<W; c++) {
					copy[r][c] = arr[r][c];
				}
			}
			
			// 약품을 투입하지 않고도 성능검사를 통과하는 경우 고려
			if(K == 1 || check()) {
				min = 0 ;
			} else {
				size() ;
			}
			
			System.out.printf("#%d %d\n", test_case, min);
			
		}
		
		sc.close();
		
	}

	/**
	 * 성능검사를 수행하는 메소드
	 */
	private static boolean check() {
		int total = 0 ;
		
		for(int c=0; c<W; c++) {
			int cnt = 1;			// 동일한 특성이 연속적으로 몇 개 나타나는지
			int cur = copy[0][c];	// 현재 기준 특성 (초기값 0)
			
			for(int r=1; r<D; r++) {
				if(copy[r][c] == cur) {
					cnt++ ;
					// 총 K개 이상이 되었는지 확인
					if(cnt >= K) {
						total++ ;
						break ;
					}
				} else {
					cur = copy[r][c] ;	// 현재 기준 특성 변경
					cnt = 1	;			// cnt 초기화
				}
			}
		}
		
		return total == W;
	}
	

	/**
	 * 조합 크기를 결정하는 메소드
	 */
	private static void size() {
		for(int i=1; i<K; i++) {
			combi(0, 0, i) ;
		}
	}

	/**
	 * 결정된 조합 크기에 따라 조합을 진행하는 메소드
	 */
	private static void combi(int idx, int selNum, int totalSel) {
		// size()에서 결정한 조합 크기만큼 요소를 선택했으면 메소드 종료
		if (selNum == totalSel) {
			if(check()) {
				min = (totalSel < min) ? totalSel : min ;
				return ;
			}
			return ;
		}
		
		// idx 크기가 보호 필름의 두께의 크기를 벗어났으면 pass
		if (idx >= D) return ;
		
		// 해당 요소에 'A'를 넣는 경우
		for(int c=0; c<W; c++) {
			copy[idx][c] = 0 ;
		}
		combi(idx+1, selNum+1, totalSel) ;
		
		// 해당 요소에 'B'를 넣는 경우
		for(int c=0; c<W; c++) {
			copy[idx][c] = 1 ;
		}
		combi(idx+1, selNum+1, totalSel) ;
		
		// 변경한 copy 배열 되돌리기
		for(int c=0; c<W; c++) {
			copy[idx][c] = arr[idx][c] ;
		}
		
		// 해당 요소를 넣지 않는 경우
		combi(idx+1, selNum, totalSel) ;
	}

}