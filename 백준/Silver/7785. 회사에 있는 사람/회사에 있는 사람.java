import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();	// 로그에 기록된 출입 기록의 수
		HashSet<String> enterHash = new HashSet<String>() ;	// 현재 회사에 있는 사람을 기록하는 리스트
		
		for(int i=0; i<n; i++) {
			String name = sc.next();		// 사람 이름
			String status = sc.next();		// enter or leave 
			
			if (status.equals("enter")) {
				enterHash.add(name) ;		// 들어오면 enterHash에 추가
			} else {
				enterHash.remove(name) ;	// 퇴근하면 enterHash에서 제거
			}
		}
		
		// 리스트로 옮기기
		List<String> enterList = new ArrayList<>(enterHash) ;
		
		// 사전순으로 정렬
		Collections.sort(enterList);
		
		// 출력
		for(int i=enterList.size()-1; i>=0; i--) {
			System.out.println(enterList.get(i));
		}
		
		sc.close();
		
	}

}
