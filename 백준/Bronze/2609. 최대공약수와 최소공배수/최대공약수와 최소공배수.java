import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int max = Math.max(n1, n2) ;
		int min = Math.min(n1, n2) ;
		
		int maxDiv = 0;
		int minMult = 0;
		
		for(int i=1; i<=min; i++) {
			// 종료조건
			if(maxDiv != 0 && minMult != 0) break ;
			
			// 최대공약수
			if(maxDiv == 0 && min % i == 0) {
				int div = min / i ;
				if(max % div == 0) maxDiv = div ;
			}
			
			// 최소공배수
			if(minMult == 0) {
				int mult = max * i ;
				if(mult % min == 0) minMult = mult ;
			}
		}
		
		System.out.println(maxDiv);
		System.out.println(minMult);
		
		sc.close();
		
	}

}
