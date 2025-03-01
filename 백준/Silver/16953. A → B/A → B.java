import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long a = Integer.valueOf(st.nextToken());
		long b = Integer.valueOf(st.nextToken());
		
		System.out.println(search(a, b));
	}
	
	public static int search(long a, long b) {
		int cnt = 0;
		
		Queue<Long> queue = new LinkedList<>();
		queue.add(a);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				long n = queue.poll();
				
				if(n == b) {
					return cnt+1;
				}
				
				if(n*2 <= b) {
					queue.add(n*2);
				}
				
				if(n*10+1 <= b) {
					queue.add(n*10+1);
				}
			}
			
			cnt++;
		}
		
		return -1;
	}
}