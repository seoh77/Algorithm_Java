import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Document {
		int sequence ;		// 순서
		int importance;		// 중요도
		
		Document(int s, int i) {
			this.sequence = s;
			this.importance = i;
		}
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=0; t<TC; t++) {
			int n = sc.nextInt();	// 문서의 개수
			int m = sc.nextInt();	// 몇 번째로 인쇄되었는지 궁금한 문서가 현재 큐에서 몇 번째에 놓여 있는지
			
			Queue<Document> queue = new LinkedList<Document>();
			
			for(int i=0; i<n; i++) {
				queue.add(new Document(i, sc.nextInt()));
			}
			
			int answer = 0;
			
			while(true) {
				Document document = queue.poll();
				boolean check = true;
				
				// 큐를 돌면서 자신보다 중요도가 높은 문서가 있는지 확인
				for(Document d : queue) {
					if(document.importance < d.importance) {
						check = false;
						break;
					}
				}
				
				if(check) {
					answer++;
					if(document.sequence == m) break;
				} else {
					// 자신보다 중요도가 더 높은 문서가 있다면 다시 큐에 넣기
					queue.add(document);
				}
			}
			
			System.out.println(answer);
		}
		
		sc.close();
		
	}
}
