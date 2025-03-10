import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] stickers = new int [2][n+1];
			int[][] dp = new int [2][n+1];
			
			for(int r=0; r<2; r++) {
				String[] input = br.readLine().split(" ");
				for(int c=1; c<=n; c++) {
					stickers[r][c] = Integer.parseInt(input[c-1]);
				}
			}
			
			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];
			
			for(int i=2; i<=n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
