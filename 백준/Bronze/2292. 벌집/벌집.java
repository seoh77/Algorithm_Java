import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()) ;
		int max = 1 ;
		int i = 0 ;
		
		while (true) {
			if (N <= max ) {
				break ;		
			} else {
				i++ ;
				max += 6*i ;
			}
		}
		
		System.out.println(i+1);
		
	}
}