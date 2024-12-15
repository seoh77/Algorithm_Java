import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] num = new int [k+1][n+1];
			
			for(int r=0; r<=k; r++) {
				for(int c=1; c<=n; c++) {
					if(r == 0) {
						num[r][c] = c;
						continue;
					}
					
					int sum = 0;
					
					for(int i=1; i<=c; i++) {
						sum += num[r-1][i];
					}
					
					num[r][c] = sum;
				}
			}
			
			System.out.println(num[k][n]);
		}
		
		sc.close();
		
	}

}