import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		// 참가자의 수
		int[] size = new int [6];	// 티셔츠 사이즈별 신청자의 수
		
		for(int i=0; i<6; i++) {
			size[i] = sc.nextInt();
		}
		
		int t = sc.nextInt();		// 티셔츠 묶음 수
		int p = sc.nextInt();		// 펜 묶음 수
		
		int tSum = 0;
		
		for(int i=0; i<6; i++) {
			tSum += size[i] / t;
			
			if(size[i] % t > 0) {
				tSum++;
			}
		}
		
		int pens = n / p;
		int pen = n % p;
		
		System.out.println(tSum);
		System.out.println(pens + " " + pen);
		
		sc.close();
	}

}
