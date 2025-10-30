import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sum = 0;
		String[] inputNum = sc.next().split("");
		for(int n=0; n<N; n++) {
			sum += Integer.parseInt(inputNum[n]);
		}
		
		System.out.println(sum);
	}
}