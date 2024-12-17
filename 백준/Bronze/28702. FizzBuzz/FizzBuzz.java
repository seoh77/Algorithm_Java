import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3; i++) {
			String str = sc.next();
			
			if(str.equals("Fizz") || str.equals("Buzz") || str.equals("FizzBuzz")) continue;
			
			int num = Integer.parseInt(str) + (3-i);
			String answer = "";
			
			if(num % 3 == 0) {
				answer += "Fizz";
			}
			
			if(num % 5 == 0) {
				answer += "Buzz";
			}
			
			if(answer == "") {
				answer = num + "";
			}
			
			System.out.println(answer);
			break;
		}
		
		sc.close();
		
	}
}
