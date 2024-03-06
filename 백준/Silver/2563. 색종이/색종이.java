import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] drawPaper = new boolean [101][101] ;
		int N = Integer.parseInt(br.readLine());
		int total = 0 ;
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			
			for (int l=left; l<left+10; l++) {
				for (int b=bottom; b<bottom+10; b++) {
					if (!drawPaper[l][b]) {
						drawPaper[l][b] = true ; 
						total++ ;
					}
				}
			}
		}
		
		System.out.println(total);
		
	}
}