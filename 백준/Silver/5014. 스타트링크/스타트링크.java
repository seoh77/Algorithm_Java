import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int F = sc.nextInt();		// 스타트링크가 있는 건물의 총 층 수
		int S = sc.nextInt();		// 강호가 지금 있는 곳 
		int G = sc.nextInt();		// 스타트링크가 있는 건물 층 수 
		int U = sc.nextInt();		// U버튼을 누르면 위로 U층 이동
		int D = sc.nextInt();		// D버튼을 누르면 아래로 D층 이동
		
		int[] arr = new int [F+1] ;		// 방문을 체크하기 위한 배열
		
		// 큐 생성
		Queue<Integer> queue = new LinkedList<Integer>() ;
		
		queue.add(S) ;			// 강호가 현재 있는 위치 큐에 넣기
		arr[S] = 1 ;			// 방문했다는 의미로 값 변경
		
		int cnt = -1 ;			// 버튼을 누른 횟수 (while문에서 바로 1증가 할 것이므로 초기값 -1)
		int sucess = 0 ;		// G에 도착했는지 여부를 체크
		
		while(!queue.isEmpty()) {
			// 큐에서 현재 위치 꺼내기
			int nf = queue.poll() ;
			
			// 버튼 클릭 
			cnt = arr[nf] - 1 ;		// 처음 arr[S]에 1을 대입했기 때문에 여기서는 1 빼주기
			
			// G층에 도착했을 경우 지금까지 버튼 누른 횟수를 반영하고 while문 종료 
			if(nf == G) {
				sucess = 1 ;		// G에 도착했음을 표시
				break ;
			}
			
			// U버튼을 누르는 경우
			if(nf+U <= F && arr[nf+U] == 0) {
				queue.add(nf+U) ;
				arr[nf+U] = arr[nf] + 1 ;
			}
			
			// D버튼을 누르는 경우
			if(nf-D > 0 && arr[nf-D] == 0) {
				queue.add(nf-D) ;
				arr[nf-D] = arr[nf] + 1 ;
			}
		}
		
		// G에 도착해서 while문이 종료되었을 경우에만 cnt 출력
		if (sucess == 1) {
			System.out.println(cnt);
		} else {
			System.out.println("use the stairs");
		}
		
		sc.close();
		
	}

}
