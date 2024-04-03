import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int num ;
	static int[] arr ;
	static int answer ;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		StringBuilder sb = new StringBuilder() ;
		
		// 기준 배열
		int N = sc.nextInt();
		arr = new int [N] ;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		// 배열에 존재하는지 확인해야 하는 값 
		
		int M = sc.nextInt();
		int[] searchArr = new int [M] ;
		for(int i=0; i<M; i++) {
			searchArr[i] = sc.nextInt();
		}
		
		// 값이 포함되어 있는지 확인
		for(int i=0; i<M; i++) {
			num = searchArr[i] ;
			answer = 0 ;
			
			search(0, N-1) ;
			sb.append(answer+"\n") ;
		}

		System.out.println(sb);
		
		sc.close();
		
	}

	private static void search(int start, int end) {
		if (start > end) return ;
		
		int mid = (start+end) / 2 ;
		
		if(num == arr[mid]) {
			answer = 1 ;
			return ;
		} else if (num > arr[mid]) {
			search(mid+1, end) ;
		} else if (num < arr[mid]) {
			search(start, mid-1) ;
		}
	}

}
