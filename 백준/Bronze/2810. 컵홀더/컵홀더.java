import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();			// 좌석의 수
		String str = sc.next();			// 좌석의 정보
		String[] arr = str.split("");
		
		// 컵홀더의 개수 구하기
		int num = 1 ;			// 컵홀더의 개수 변수 (양 끝 좌석에는 양 쪽으로 컵홀더가 있기 때문에 초기값을 1로 설정)
		int cnt = 0 ;			// 커플석의 계산하기 위한 변수
		for(int i=0; i<arr.length; i++) {
			if (arr[i].equals("S")) {
				num ++ ;		// 일반 좌석이 나오면 바로 +1
			} else if (arr[i].equals("L")) {
				cnt++ ;
				// 커플석일 경우 2개가 연달아 나오고 난 후 컵홀더 개수 +1
				if (cnt == 2) {
					num++ ;
					cnt = 0 ;
				}
			}
		}
		
		// 컵홀더에 컵을 놓을 수 있는 사람의 수
		int answer = 0 ;
		if (num < N) {
			answer = num ;
		} else {
			answer = N ;
		}
		
		System.out.println(answer);
        
		sc.close();
		
	}
	
}
