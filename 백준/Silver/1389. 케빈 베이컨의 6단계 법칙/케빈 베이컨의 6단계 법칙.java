import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static boolean[][] friends;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());		// 유저 수
		int m = Integer.parseInt(st.nextToken());	// 친구 관계 수
		
		// 친구 관계 입력
		friends = new boolean [n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			friends[p1][p2] = friends[p2][p1] = true;
		}
		
		// 각 사람의 케빈 베이컨의 수 계산
		int[] kevinBaconSum = new int [n+1];
		
		for(int p=1; p<=n; p++) {
			kevinBaconSum[p] = kevinBacon(p);
		}
		
		
		// 케빈 베이컨의 수가 가장 작은 사람 구하기
		int answer = 0;
		int min = Integer.MAX_VALUE;
		
		for(int p=1; p<=n; p++) {
			if(kevinBaconSum[p] < min) {
				min = kevinBaconSum[p];
				answer = p;
			}
		}
		
		System.out.println(answer);
		
	}
	
	/**
	 * 케빈 베이컨의 수를 계산하는 메소드
	 * @param p 구하고자 하는 사람의 번호
	 * @return 케빈 베이컨의 수
	 */
	public static int kevinBacon(int p) {
		int sum = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		int[] time = new int [n+1];
		
		queue.add(p);
		time[p] = 0;
		
		while(!queue.isEmpty()) {
			int p1 = queue.poll();
			
			for(int p2=1; p2<=n; p2++) {
				if(p == p2 || time[p2] != 0 || !friends[p1][p2]) continue;

				time[p2] = time[p1] + 1; 
				queue.add(p2);
				sum += time[p2];
			}
		}
		
		return sum;
	}
}