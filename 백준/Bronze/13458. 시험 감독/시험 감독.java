import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();		// N개의 시험장
		int[] arr = new int [N] ;	// 각 시험장의 응시자수
		
		// 응시자 수 입력
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();		// 총감독관이 한 시험장에서 감시할 수 있는 응시자수
		int C = sc.nextInt();		// 부감독관이 한 시험장에서 감시할 수 있는 응시자수
		
		long total = 0 ;				// 필요한 감독관 수의 최솟값
		
		for(int i=0; i<N; i++) {
			int p = arr[i] ;		// 한 시험장의 응시자수
			
			// 총감독관이 감시하는 인원
			// 그냥 p-=B로 하는 경우 부감독관이 감시하는 인원으로 음수값이 넘어가서 출력 값이 달라짐
			p = (p < B) ? 0 : p-B ;
			total++ ;
			
			// 부감독관이 감시하는 인원
			total += (int) Math.ceil((double)p/C) ;
		}
		
		System.out.println(total);
		
		sc.close();
		
	}

}
