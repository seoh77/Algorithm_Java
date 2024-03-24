import java.util.Scanner;

public class Main {
	
	static int[] arr ;
	static int M ;
	static boolean[] visited ;
	static int[] select ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();
		arr = new int [N] ;
		for(int i=1; i<=N; i++) {
			arr[i-1] = i ;
		}
		M = sc.nextInt();
		visited = new boolean [N] ;
		select = new int [M] ;
		
		perm(0, 0) ;
		
		sc.close();
		
	}

	private static void perm(int idx, int selNum) {
		if (selNum == M) {
			// 출력
			for(int i=0; i<select.length; i++) {
				System.out.print(select[i]+" ");
			}
			System.out.println();
			
			// 재귀 종료
			return ;
		}
		
		if (idx >= arr.length) return ;
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				select[selNum] = arr[i] ;
				visited[i] = true ;
				perm(idx+1, selNum+1) ;
				visited[i] = false ;
			}
		}
	}

}
