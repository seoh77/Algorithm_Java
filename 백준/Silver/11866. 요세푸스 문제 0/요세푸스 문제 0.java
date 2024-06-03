import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();			// 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있음 
		int k = sc.nextInt();			// 순서대로 K번째 사람을 제거
		
		List<Integer> circle = new ArrayList<Integer>() ;		// 원에 있는 사람들을 저장하는 리스트
		int[] answer = new int [n] ;							// 제거되는 순서를 저장하는 배열
		
		// 리스트에 사람의 번호 추가
		for(int i=1; i<=n; i++) {
			circle.add(i) ;
		}
		
		// 순서대로 사람 제거
		int idx = 0;
		for(int i=0; i<n; i++) {
			// idx 위치 설정
			idx = (idx + (k-1)) % (circle.size()) ;
			
			answer[i] = circle.get(idx) ;
			circle.remove(idx) ;
		}
		
		// 출력
		for(int i=0; i<n; i++) {
			if(i == 0) {
				System.out.print("<");
			}
			
			System.out.print(answer[i]);
			
			if(i != (n-1)) {
				System.out.print(", ");
			} else {
				System.out.print(">");
			}
		}
		
		sc.close();
		
	}

}
