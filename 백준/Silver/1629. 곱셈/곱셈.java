import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		
		System.out.println(pow(a, b));
	}
	
	public static long pow(long a, long exponent) {
		// 지수가 1인 경우 그대로 a를 리턴
		if(exponent == 1) {
			return a % c;
		}
		
		// 지수법칙을 활용
		long temp = pow(a, exponent/2);
		
		// 지수가 홀수인 경우 a를 한 번 더 곱해줘야 한다.
		if(exponent % 2 == 1) {
			return (temp * temp % c) * a % c;
		}
		
		return temp * temp % c;
	}
}
