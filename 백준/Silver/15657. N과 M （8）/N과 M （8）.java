import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] arr ;
	static int M ;
	static int[] select ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();			// N개의 자연수
		arr = new int [N] ;
		
		M = sc.nextInt();				// 길이가 M인 수열
		select = new int [M] ;
		
		// 자연수 값 입력받기
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// arr 배열 정렬
		Arrays.sort(arr);
		
		combi(0, 0) ;
		
		sc.close();
		
	}

	private static void combi(int idx, int selNum) {
		if (selNum == M) {
			// 출력
			for(int i=0; i<select.length; i++) {
				System.out.print(select[i]+" ");
			}
			System.out.println();
			
			// 종료
			return;
		}
		
		// 종료조건 
		if (idx >= arr.length) return ;
		
		for(int i=idx; i<arr.length; i++) {
			select[selNum] = arr[i] ;
			combi(i, selNum+1) ;
		}
		
	}

}
