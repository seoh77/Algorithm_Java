import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		// 상근이가 가지고 있는 숫자 카드 저장
		HashMap<Integer, Integer> getCard = new HashMap<Integer, Integer>() ;
		
		int n = sc.nextInt();			// 상근이가 가지고 있는 숫자 카드의 개수
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			getCard.put(num, getCard.getOrDefault(num, 0)+1) ;
		}
		
		StringBuilder sb = new StringBuilder() ;
		
		int m = sc.nextInt();		// 체크할 숫자 카드 개수
		for(int i=0; i<m; i++) {
			int num = sc.nextInt();
			sb.append(getCard.getOrDefault(num, 0)).append(' ') ;
		}
		
		System.out.println(sb);
		
		sc.close();
		
	}

}
