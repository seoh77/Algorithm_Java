import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Person {
		int idx ;		// 해당 사람의 번호
		int cnt ;		// startNum부터 계산된 촌수
		
		Person(int idx, int cnt) {
			this.idx = idx ;
			this.cnt = cnt ;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();					// 전체 사람의 수
		int startNum = sc.nextInt();			// 촌수를 계산해야 하는 사람의 번호 (시작)
		int endNum = sc.nextInt(); 				// 촌수를 계산해야 하는 사람의 번호 (도착) 
		int m = sc.nextInt();					// 부모 자식들 간의 관계의 개수
		
		int[][] adj = new int [n+1][n+1] ;				// 부모 자식 관계를 표시하기 위한 배열
		boolean[] visited = new boolean [n+1] ;			// 방문한 요소를 체크하기 위한 배열
		
		// 부모 자식 관계 입력
		for(int i=0; i<m; i++) {
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			
			adj[p1][p2] = adj[p2][p1] = 1 ;
		}

		Queue<Person> queue = new LinkedList<Person>() ;
		
		queue.add(new Person(startNum, 0)) ;	// 큐에 시작번호 넣기
		visited[startNum] = true ;				// 시작번호 방문처리 
		int answer  = -1;
		
		// 큐에 값이 없을 때까지 반복
		while(!queue.isEmpty()) {
			// 큐에 저장되어 있는 사람 정보 꺼내기 (번호, 해당 사람의 촌수)
			Person person = queue.poll() ;
			int idx = person.idx ;
			int cnt = person.cnt ;
			
			// 만약 도착 번호라면 answer에 cnt값을 대입하고 반복문 종료
			if (idx == endNum) {
				answer = cnt ;
				break ;
			}
			
			// 아직 도착하지 않았다면, 모든 번호를 돌면서 해당 번호와 연결된 번호들 큐에 넣기
			for(int i=1; i<=n; i++) {
				if(!visited[i] && adj[idx][i] == 1) {
					queue.add(new Person(i, cnt+1)) ;		// 큐에 번호 넣기 
					visited[i] = true ;						// 방문처리
				}
			}
		}
		
		// 출력
		System.out.println(answer);
		
		sc.close();
		
	}

}
