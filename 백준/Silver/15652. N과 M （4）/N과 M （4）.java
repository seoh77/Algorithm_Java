import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());	// 1부터 N까지 자연수 중에 선택 가
		m = Integer.parseInt(st.nextToken());	// M개의 수를 선택해야 함
		
		int[] arr = new int [m];	// 만들어진 수열을 저장하는 배열
		
		combi(0, arr);
	}
	
	/**
	 * 수열 만드는 메서드
	 */
	public static void combi(int idx, int[] arr) {
		// 종료조건
		if(idx >= m) {
			print(arr);
			return;
		}
		
		int start = (idx == 0) ? 1 : arr[idx-1];
		
		for(int i=start; i<=n; i++) {
			arr[idx] = i;
			combi(idx+1, arr);
		}
	}
	
	public static void print(int[] arr) {
		for(int i=0; i<m; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
