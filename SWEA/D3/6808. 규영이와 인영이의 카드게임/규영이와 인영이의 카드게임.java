import java.io.File;
import java.util.Scanner;

public class Solution {
	
	static int[] p1Card ;
	static int[] p2Card ;
	static boolean[] cardArr ;
	
	static int[] getP2Card ;
	static boolean[] visited ;
	
	static int win ;
	static int lose ;
	
	public static void main(String[] args) throws Exception {
		
		// File file = new File("src/swea_6806_규영이와_인영이의_카드게임/input.txt") ;
		// Scanner sc = new Scanner(file) ;
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			// 값 초기화
			p1Card = new int [9] ;				// 규영이 카드 배열 (저장된 순서대로 카드를 낸다)
			p2Card = new int [9] ;				// 인영이 카드 배열	(저장된 순서대로 카드를 낸다)
			cardArr = new boolean [19] ;		// 배분된 카드 숫자 true, 아직 배분되지 않은 카드 숫자는 false
			
			getP2Card = new int [9] ;			// 인영이가 가지고 있는 카드 값 저장
			visited = new boolean [9] ;			// ordering할 때 이미 냈던 카드인지 구분하기 위함
			
			win = 0 ;							// 규영이가 카드에서 이기는 경우의 수 
			lose = 0 ;							// 규영이가 카드에서 지는 경우의 수
			
			// 규영이의 카드 값 입력 (입력된 순서대로 카드를 낸다)
			for(int i=0; i<9; i++) {
				int num = sc.nextInt();			// 숫자 입력
				p1Card[i] = num;				// 규영이 카드 배열(p1Card)에 저장 
				cardArr[num] = true ;			// 카드가 배분되었기 때문에 cardArr[num]을 true로 변경
			}
			
			// 인영이가 가지고 있는 카드 숫자 계산 
			int idx = 0 ;
			for(int i=1; i<19; i++) {
				if (!cardArr[i]) {
					getP2Card[idx++] = i ;
				}
			}
			
			// 인영이가 카드를 내는 순서 결정
			ordering(0) ;
			
			System.out.printf("#%d %d %d\n", test_case, win, lose);
			
		}
		
		sc.close();
		
	}

	private static void ordering(int cnt) {
		// 9개의 숫자가 모두 정해졌으면 승패 비교
		if (cnt == 9) {
			score() ;
			return ;
		}
		
		for(int i=0; i<getP2Card.length; i++) {
			// 이미 냈던 카드면 pass
			if (visited[i]) continue ;
			
			visited[i] = true ;
			p2Card[cnt] = getP2Card[i] ;
			ordering(cnt+1) ;
			visited[i] = false ;
		}
	}

	private static void score() {
		int p1Score = 0 ;			// 규영이 점수
		int p2Score = 0 ;			// 인영이 점수
		
		for(int i=0; i<9; i++) {
			int sum = p1Card[i] + p2Card[i] ;		// 이번 라운드에 낸 두 카드에 적힌 수의 합
			
			// 더 큰 값의 숫자 카드를 낸 사람의 점수에 +sum
			if (p1Card[i] > p2Card[i]) {
				p1Score += sum ;
			} else if (p1Card[i] < p2Card[i]) {
				p2Score += sum ;
			}
		}
		
		// 9라운드가 종료되었을 때 총점이 더 높은 사람이 승자
		// 규영이를 기준으로 이기는 경우의 수와 지는 경우의 수를 계산
		if (p1Score > p2Score) win++ ;
		else lose++ ;
	}

}
