import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] arr ;
	static int M ;
	
	static boolean[] visited ;
	static int[] select ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();			// N개의 자연수를 입력
		arr = new int [N] ;				// 입력받은 자연수를 담아둘 배열 
		visited = new boolean [N] ;		// 배열에 넣은 자연수를 체크하기 위한 배열
		
		M = sc.nextInt() ;				// 길이가 M인 수열 
		select = new int [M] ;			// 선택한 자연수를 기록해둘 배열
		
		// 자연수 입력받기
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);			// 사전순으로 정렬해서 출력하기 위함
		
		perm(0) ;
		
		sc.close();
		
	}

	private static void perm(int selNum) {
		if (selNum == M) {
			// 출력
			for(int i=0; i<select.length; i++) {
				System.out.print(select[i]+" ");
			}
			System.out.println();
			
			// 재귀 종료
			return ;
		}
		
		// 순열
		for(int i=0; i<arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true ;
				select[selNum] = arr[i] ;
				perm(selNum+1) ;
				visited[i] = false ;
			}
		}
	}

}
