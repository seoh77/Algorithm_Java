import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] p = new int [n];
		
		for(int i=0; i<n; i++) {
			p[i] = sc.nextInt();
		}
		
		Arrays.sort(p);
		
		int[] waitTime = new int [n];
		waitTime[0] = p[0];
		int answer = p[0];
		
		for(int i=1; i<n; i++) {
			waitTime[i] = waitTime[i-1] + p[i];
			answer += waitTime[i];
		}
		
		System.out.println(answer);
		
		sc.close();
		
	}
}