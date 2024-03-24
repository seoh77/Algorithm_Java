import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] arr ;
	static int M ;
	static int[] select ;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();		// N개의 자연수
		arr = new int [N] ;
		
		M = sc.nextInt();			// 길이가 M인 수열 
		select = new int [M];		// 선택한 자연수를 담아둘 배열
		
		// 자연수 값 입력받기
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);			// 사전순으로 정렬해서 출력하기 위함
		
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
		
		// 재귀 종료 조건
		if (idx >= arr.length) return ;
		
		// 이번 idx 선택 O
		select[selNum] = arr[idx] ;
		combi(idx+1, selNum+1) ;
		
		// 이번 idx 선택 X
		combi(idx+1, selNum) ;
	}
	
}
