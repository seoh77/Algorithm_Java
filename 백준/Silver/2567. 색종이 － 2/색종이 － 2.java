import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int num = sc.nextInt();				// 색종이의 수
		int[][] arr = new int [101][101] ;	// 흰색 도화지 배열
		int total = 0; 						// 색종이가 붙은 검은 영역의 둘레의 길이
		
		for(int n=0; n<num; n++) {
			int left = sc.nextInt();		// 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
			int bottom = sc.nextInt();		// 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
			
			// 흰색 도화지에 색종이 붙이기
			for(int c=left; c<left+10; c++) {
				for(int r=bottom; r<bottom+10; r++) {
					arr[r][c] = 1 ;
				}
			}
		}
		
		// 둘레 길이 측정
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[r].length; c++) {
				
				if (arr[r][c] != 1) continue ;
				
				int[] dr = {1, -1, 0, 0} ;
				int[] dc = {0, 0, 1, -1} ;
				
				for(int d=0; d<dr.length; d++) {
					int nr = r + dr[d] ;
					int nc = c + dc[d] ;
					
					if(arr[nr][nc] == 0) total++ ;
				}
				
			}
		}
		
		System.out.println(total);
		
		sc.close();
		
	}

}
