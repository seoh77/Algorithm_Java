import java.util.Scanner;

public class Main {
	
	static String[] strArr ;
	static int palindrome ;
	static int cnt ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();			// 테스트 케이스의 수
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			String str = sc.next();		// 알파벳 대문자로 구성된 문자열
			strArr = str.split("");
			palindrome = 1 ;
			cnt = 0 ;
			
			isPalindrome(0) ;
			
			System.out.println(palindrome + " " + cnt);
			
		}
		
		sc.close();
		
	}
	
	public static void isPalindrome(int idx) {
		int firstIdx = idx ;
		int secondIdx = strArr.length - 1 - idx ;
		cnt++ ;
		
		if (firstIdx >= secondIdx) {
			return ;
		}
		
		if(!strArr[firstIdx].equals(strArr[secondIdx])) {
			palindrome = 0 ;
			return ;
		}

		isPalindrome(++idx) ;
	}

}
