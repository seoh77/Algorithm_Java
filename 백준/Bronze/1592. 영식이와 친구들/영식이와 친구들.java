import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();		// 게임에 참여하는 인원
		int M = sc.nextInt();		// 한 사람이 M번 공을 받으면 게임 종료 
		int L = sc.nextInt();		// 몇 번째 사람에게 공을 던질 것인지 (시계, 반시계 방향 여부는 현재 공을 받은 횟수에 따라 달라짐)
		
		int[] arr = new int [N+1] ;	// 현재 공을 받은 횟수를 기록하는 배열 
		
		int num = 0;		// 총 공을 던진 횟수
		int curIdx = 0; 	// 현재 공을 가지고 있는 사람의 번호를 담아두기 위한 변수 
		
		while(true) {
			if (num == 0) {
				curIdx = 1 ;	// 처음에는 1번 자리에 앉은 사람이 공을 받음
			} else {
				if(arr[curIdx] % 2 == 1) {
					// 현재 공을 받은 횟수가 홀수번이면 시계방향(->)으로 L번째 있는 사람에게 공을 던짐
					curIdx = (curIdx + L > N) ? curIdx + L - N : curIdx + L ;
				} else {
					// 현재 공을 받은 횟수가 짝수번이면 반시계방향(<-)으로 L번째 있는 사람에게 공을 던짐
					curIdx = (curIdx - L <= 0) ? curIdx - L + N : curIdx - L ;
				}
			}
			
			arr[curIdx]++ ;					// 공을 받은 횟수 늘려주기
			
			if (arr[curIdx] == M) break ;	// 종료 조건에 해당하는지 판별
			
			num++ ;							// 총 공을 던진 횟수 추가 
		}
		
		System.out.println(num);
		
		sc.close();
		
	}

}
