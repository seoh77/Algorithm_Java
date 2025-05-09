import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int [n][3];
		
		for(int r=0; r<n; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<3; c++) {
				dp[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		int answer = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		System.out.println(answer);
	}
}