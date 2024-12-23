import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long r = 1;
		int m = 1234567891;
		
		int l = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		long answer = 0;
		
		for(int i=0; i<l; i++) {
			answer += (arr[i] - 'a' + 1) * r ;
			r = (r * 31) % m;
		}
		
		System.out.println(answer % m);
		
		sc.close();
		
	}
}
