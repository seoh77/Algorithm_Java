import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int [n+1][m+1] ;			// 방에 놓여져있는 사탕의 개수
		int[][] sumCandy = new int [n+1][m+1] ;		// 사탕 개수의 최댓값을 구하기 위한 배열
		
		// 방에 놓인 사탕 개수 입력
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=m; c++) {
				arr[r][c] = sumCandy[r][c] = sc.nextInt();
			}
		}
		
		// 델타배열
		int[] dr = {-1, 0, -1} ;
		int[] dc = {0, -1, -1} ;
		
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=m; c++) {
				
				for(int d=0; d<3; d++) {
					int nr = r + dr[d] ;
					int nc = c + dc[d] ;
					
					// 배열 범위 초과
					if(nr <= 0 || nr > n || nc <= 0 || nc > m) continue ;
					
					// 최댓값 갱신
					int sum = arr[r][c] + sumCandy[nr][nc] ;
					sumCandy[r][c] = (sum > sumCandy[r][c]) ? sum : sumCandy[r][c] ;
				}
				
			}
		}
		
		// (N, M)으로 이동할 때, 가져올 수 있는 사탕의 최댓값
		System.out.println(sumCandy[n][m]);
		
		sc.close();
		
	}

}
