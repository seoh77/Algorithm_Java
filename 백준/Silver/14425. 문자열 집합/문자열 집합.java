import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] setArr = new String [N] ;
		for (int i=0; i<setArr.length; i++) {
			setArr[i] = br.readLine() ;
 		}
		
		int count = 0 ;
		for (int i=0; i<M; i++) {
			String search = br.readLine() ;
			
			for (String set : setArr) {
				if (set.equals(search)) count++ ;
			}
		}
		
		System.out.println(count);
		
	}
}