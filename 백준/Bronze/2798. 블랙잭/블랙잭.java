import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

 public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] cardNumString = br.readLine().split(" ");
        int[] cardNum = Stream.of(cardNumString).mapToInt(Integer::parseInt).toArray();
		
		int answer = 0 ;
		
		for (int i=0; i<cardNum.length-2; i++) {
			for (int j=i+1; j<cardNum.length-1; j++) {
				for (int z=j+1; z<cardNum.length; z++) {
					int sum = cardNum[i]+cardNum[j]+cardNum[z] ;
					if (sum>answer && sum<=M) answer = sum ;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}