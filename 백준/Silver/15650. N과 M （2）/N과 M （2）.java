import java.util.Scanner;

public class Main {
	
	static int[] arr ;
	static int M ;
	static int[] select ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();
		
		// 1부터 N까지 자연수 배열 만들기
		arr = new int [N] ;
		for(int i=1; i<=N; i++) {
			arr[i-1] = i ;
		} 
		
		M = sc.nextInt() ;		// M개를 선택
		select = new int [M] ;		// 선택된 자연수를 담아두는 배열
		
		combi(0, 0) ;
		
		sc.close();
		
	}

	private static void combi(int idx, int selNum) {
		if (selNum == M) {
			// select 배열 출력
			for(int i=0; i<select.length; i++) {
				System.out.print(select[i]+" ");
			}
			System.out.println();
			
			// 재귀 종료
			return ;
		}
		
		if (idx >= arr.length) {
			return ;
		}

		// 현재 idx 선택함 
		select[selNum] = arr[idx] ;
		combi(idx+1, selNum+1) ;
		
		// 현재 idx 선택하지 않음
		combi(idx+1, selNum) ;
		
	}

}
