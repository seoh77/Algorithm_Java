import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt();		// 포켓몬 수
		int m = sc.nextInt();		// 문제 수
		
		// 포켓몬 도감 만들기 (번호와 이름)
		HashMap<Integer, String> searchNameBook = new HashMap<Integer, String>() ;
		HashMap<String, Integer> searchNumBook = new HashMap<String, Integer>() ;
		
		for(int num=1; num<=n; num++) {
			String name = sc.next() ;
			searchNameBook.put(num, name) ;
			searchNumBook.put(name, num) ;
		}
		
		// 문제 맞추기
		for(int p=1; p<=m; p++) {
			String problem = sc.next();		// 맞춰야 하는 값 입력
			
			try {
				// problem을 숫자로 변환했을 때 정상적으로 변환이 되면 숫자에 해당하는 포켓몬 이름을 출력
				int num = Integer.parseInt(problem) ;
				System.out.println(searchNameBook.get(num));
			} catch (NumberFormatException e) {
				// NumberFormatException이 발생하면 포켓몬 이름이 입력된 것이므로 포켓몬 이름에 해당하는 번호 출력
				System.out.println(searchNumBook.get(problem));
			}
		}
		
		sc.close();
		
	}

}
