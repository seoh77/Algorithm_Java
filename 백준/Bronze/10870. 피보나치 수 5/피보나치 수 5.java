import java.util.Scanner;

public class Main {
	
	static int sum ;
	static int n ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		n = sc.nextInt();			// n번째 피보나치 수 출력
		
		if (n == 0) {
			sum = 0 ;
		} else if (n == 1) {
			sum = 1 ;
		} else {
			n-- ;
			fibo(0, 1) ;
		}
		
		System.out.println(sum);
		
		sc.close();
		
	}
	
	public static void fibo(int prev, int now) {
		if(n == 0) return ;
		
		sum = prev + now ;
		n-- ;
		fibo(now, sum) ;
	}

}
