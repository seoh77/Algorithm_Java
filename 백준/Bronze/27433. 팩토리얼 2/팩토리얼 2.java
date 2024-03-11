import java.util.Scanner;

public class Main {
	
	static long answer ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();		
		answer = 1;
		
		if (N != 0) {
			mult(N) ;
		}
		
		System.out.println(answer);
		
		sc.close();
		
	}
	
	public static void mult(int num) {
		if (num == 0) return ;
		answer *= num ;
		mult(--num) ;
	}

}
