import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();		// 문자열의 개수
		int m = sc.nextInt();		// 검사하는 문자열 개수
		
		// 집합 s에 문자열 저장
		String[] sArr = new String [n] ;
		for(int i=0; i<n; i++) {
			sArr[i] = sc.next();
		}
		
		int cnt = 0 ;		// 입력된 문자열 중 총 몇 개가 집합 S에 포함되어 있는지 체크할 변
		
		// 문자열 검사
		for(int i=0; i<m; i++) {
			String check = sc.next();		// 검사하고자 하는 문자열
			
			for(int j=0; j<sArr.length; j++) {
				// 집합 S의 요소들을 하나씩 탐색하며 check가 포함되어 있는지 확인하고,
				if (sArr[j].equals(check)) {
					cnt++ ;
					break ;		// 포함되어 있을 경우 cnt를 증가시키고 바로 종료 (시간 단축을 위함)
				}
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
		
	}

}
