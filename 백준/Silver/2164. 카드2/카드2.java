import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt() ;
		List<Integer> list = new LinkedList<Integer>() ;
		
		// 1부터 N까지의 번호 리스트에 넣기
		for(int i=1; i<=n; i++) {
			list.add(i) ;
		}
		
		while(list.size() > 1) {
			// 제일 위에 있는 카드를 바닥에 버리기
			list.remove(0) ;
			
			// 1개의 카드만 남아있다면 while문 종료
			if(list.size() == 1) break ;
			
			// 제거 후 남은 카드 중, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
			list.add(list.get(0)) ;
			list.remove(0) ;
		}
		
		System.out.println(list.get(0));
		
		sc.close();
		
	}

}
