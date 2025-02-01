import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static ArrayList<Integer>[] tree;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 노드의 개수
		tree = new ArrayList [n+1];				// 연결된 노드 번호를 저장
		
		for(int i=1; i<=n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		// 연결된 두 정점 저장
		for(int i=1; i<=n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		answer = new int [n+1];	// 각 노드별 부모의 번호 저장하는 배열
		search(1);
		
		// 출력
		for(int i=2; i<=n; i++) { 
			System.out.println(answer[i]);
		}
	}
	
	/**
	 * num와 연결된 자식 노드를 찾는 메소드
	 * @param num
	 */
	public static void search(int parent) {
		for(int child : tree[parent]) {
			if(answer[child] == 0) {
				answer[child] = parent;
				search(child);
			}
		}
	}
}
