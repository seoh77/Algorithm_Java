import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] arr ;
	static boolean[][] visited ;
	static int cnt ;
	
	// 델타배열
	static int[] dr = {-1, 1, 0, 0} ;
	static int[] dc = {0, 0, -1, 1} ;
	
	static class Path {
		int r, c ;
		
		Path(int r, int c) {
			this.r = r ;
			this.c = c ; 
		}
	}
	
	static Queue<Path> queue = new LinkedList<Path>() ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();			// 지도의 크기
		arr = new int[n][n] ;			// 지도 정보를 저장할 배열 설정
		visited = new boolean[n][n] ;	// 방문배열 설정
		
		// 지도 정보 입력
		for(int i=0; i<n; i++) {
			String[] str = sc.next().split("");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(str[j]) ;
			}
		}
		
		int num = 0;		// 단지 수를 계산
		List<Integer> cntList = new ArrayList<Integer>() ;		// 각 단지에 속하는 집의 수를 저장하기 위한 리스트
		
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(arr[r][c] == 1 && !visited[r][c]) {
					num++ ;			// 단지수 증가
					
					cnt = 1;		// 각 단지에 속하는 집의 수 계산 (arr[r][c]도 포함되어야 하기 때문에 초기값 1)
					visited[r][c] = true ;
					BFS(r, c) ;
					cntList.add(cnt) ;
				}
			}
		}
		
		// 각 단지에 속하는 집의 수를 오름차순으로 정렬
		int arrLen = cntList.size() ;
		int[] cntArr = new int [arrLen] ;
		for(int i=0; i<arrLen; i++) {
			cntArr[i] = cntList.get(i) ;
		}
		Arrays.sort(cntArr);
		
		// 출력
		System.out.println(num);
		for(int i=0; i<arrLen; i++) {
			System.out.println(cntArr[i]);
		}
		
		sc.close();
		
	}

	private static void BFS(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r + dr[d] ;
			int nc = c + dc[d] ;
			
			// arr 범위 벗어나면 pass 
			if(nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length) continue ;
			
			// 이미 방문했던 배열이거나 집이 없는 곳이면 pass
			if(arr[nr][nc] == 0 || visited[nr][nc]) continue ;
			
			queue.add(new Path(nr, nc)) ;
			visited[nr][nc] = true ;
			cnt++ ;
		}
		
		while(!queue.isEmpty()) {
			Path path = queue.poll() ;
			BFS(path.r, path.c) ;
		}
	}

}
