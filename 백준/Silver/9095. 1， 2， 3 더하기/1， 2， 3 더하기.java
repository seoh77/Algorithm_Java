import java.util.Scanner;

public class Main {
	
	static int n;
	static int answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=0; t<TC; t++) {
			n = sc.nextInt();
			answer = 0;
			
			permu(0);
			
			System.out.println(answer);
		}
		
		sc.close();
		
	}
	
	/**
	 * 순열을 만들기 위한 메소드
	 * @param sum : 현재까지의 합
	 */
	public static void permu(int sum) {
		if(sum >= n) {
			if(sum == n) answer++;
			return;
		}
		
		for(int i=1; i<=3; i++) {
			permu(sum+i);
		}
	}
}
