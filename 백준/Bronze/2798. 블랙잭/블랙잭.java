import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt(); 			// 카드의 개수
		int M = sc.nextInt();			// 3장의 카드 합이 M을 넘지 않아야 한다.
		int[] arr = new int [N] ;		// 딜러가 공개한 카드 배열 
		
		// 딜러가 공개한 카드 값 배열 저장
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0 ;			// M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합
		
		for(int i=0; i<=arr.length-2; i++) {
			for(int j=i+1; j<=arr.length-1; j++) {
				for(int z=j+1; z<arr.length; z++) {
					int sum = arr[i] + arr[j] + arr[z] ;
					
					if (sum > M) continue ;
					
					max = (sum > max) ? sum : max ;
					
					if (max == M) break ;
				}
			}
		}
		
		System.out.println(max);
		
		sc.close();
		
	}

}
