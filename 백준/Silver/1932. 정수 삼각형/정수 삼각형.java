import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 삼각형의 크기
		int[][] dp = new int [n+1][n+1];			// 최대합을 구하기 위한 dp 배열
		
		// dp의 초기값은 삼각형을 이루고 있는 정수로 설정
		for(int r=1; r<=n; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=1; c<=r; c++) {
				dp[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 최대합 계산
		for(int r=n-1; r>0; r--) {
			for(int c=1; c<=r; c++) {
				dp[r][c] = dp[r][c] + Math.max(dp[r+1][c], dp[r+1][c+1]);
			}
		}
		
		System.out.println(dp[1][1]);
	}
}


