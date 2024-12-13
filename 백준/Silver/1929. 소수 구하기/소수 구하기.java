import java.util.Scanner;

public class Main {
	
	static boolean[] composite;		// true : 합성수, false : 소수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		composite = new boolean [n+1];
		isPrime();
		
		for(int i=m; i<=n; i++) {
			if(!composite[i]) {
				System.out.println(i);
			}
		}
		
		sc.close();
		
	}
	
	public static void isPrime() {
		composite[0] = composite[1] = true;
		
		for(int i=2; i<=Math.sqrt(composite.length); i++) {
			if(composite[i]) continue;
			
			for(int j=i*i; j<composite.length; j+=i) {
				composite[j] = true;
			}
		}
	}

}
