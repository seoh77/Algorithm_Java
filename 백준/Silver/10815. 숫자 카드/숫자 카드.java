import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] getCard;
	static int checkValue ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();			// 상근이가 가지고 있는 숫자 카드의 개수
		getCard = new int [n];			// 상근이가 가지고 있는 숫자 카드 배열
		
		for(int i=0; i<getCard.length; i++) {
			getCard[i] = sc.nextInt();
		}
		
		Arrays.sort(getCard); 			// getCard 배열 정렬
		
		int m = sc.nextInt();			// 판별해야 되는 숫자의 개수
		StringBuffer sb = new StringBuffer();		// -> 계속된 시간초과로 인해 사용..
		
		for(int i=0; i<m; i++) {
			checkValue = sc.nextInt();
			
			int answer = binarySearch(0, getCard.length-1) ;
			sb.append(answer+" ") ;
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	public static int binarySearch(int left, int right) {
		// 재귀함수보다는 반복문이 더 빠르기 때문에 while문으로 수정
		while (left <= right) {
			int mid = (right + left) / 2 ;		// 중간값을 설정
			
			if (getCard[mid] == checkValue) {
				return 1 ;		// checkValue가 중간값과 같으면 메소드 종료 
			} else if (getCard[mid] > checkValue) {
				right = mid - 1;	// checkValue가 중간값보다 왼쪽에 있으면 right 변수값을 수정
			} else {
				left = mid + 1 ;	// checkValue가 중간값보다 오른쪽에 있으면 left 변수값을 수정
			}
		}
		
		return 0 ;		// while문이 종료되었음에도 값을 찾지 못했다면 상근이가 가지고 있지 않은 숫자
	}

}
