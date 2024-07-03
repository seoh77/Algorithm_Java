import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int d = sc.nextInt();		// 할머니가 넘어온 날
		int k = sc.nextInt();		// 호랑이에게 준 떡의 개수
		int[] fibo = new int [d+1];	// 피보나치 수열을 저장할 배열
		
		// 피보나치 수열 초기화
		fibo[1]=1;
		fibo[2]=1;
		for(int i=3; i<=d; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		// A와 B 찾기
		int a = 1;
		int b = 1;
		
		while(true) {
			int sum = a * fibo[d-2] + b * fibo[d-1];
			
			if(sum == k) {
				break;
			} else if (sum < k) {
				b++;
			} else {
				a++;
				b = a;
			}
		}
		
		System.out.println(a);
		System.out.println(b);
		
		sc.close();
		
	}

}
