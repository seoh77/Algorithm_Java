import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] arr ;
	static int M ;
	static int[] select ;
	
	static StringBuilder sb = new StringBuilder() ;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();			// N개의 자연수
		arr = new int [N] ;
		
		M = sc.nextInt();				// 길이가 M인 수열
		select = new int [M] ;
		
		// 자연수 숫자 입력받기
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 정렬
		Arrays.sort(arr);
		
		perm(0) ;
		
		System.out.println(sb);
		
		sc.close();
		
	}

	private static void perm(int selNum) {
		if (selNum == M) {
			// 출력 
			for(int i=0; i<select.length; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n") ;
			
			// 종료
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			select[selNum] = arr[i] ;
			perm(selNum+1) ;
		}
	}
	
}
