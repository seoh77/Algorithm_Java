import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		// 버섯 점수 배열 입력 (10개의 버섯이 놓여있음)
		int[] arr = new int [10] ;
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0 ; 					// 마리오가 받는 점수
		int gap = Integer.MAX_VALUE;	// 100점과 sum 점수의 차이
		for(int i=0; i<arr.length; i++) {
			int temp = sum + arr[i] ;
			// 현재의 gap 차이보다 100-temp의 절대값 차이가 더 적게 난다면 값 갱신
			if(gap >= Math.abs(100-temp)) {
				sum = temp ;
				gap = Math.abs(100-temp) ;
			} else {
				break ;
			}
		}
		
		System.out.println(sum);
		
		sc.close();
		
	}

}
