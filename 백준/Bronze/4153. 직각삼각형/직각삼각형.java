import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		while(true) {
			int[] nArr = new int [3] ;
			
			for(int i=0; i<3; i++) {
				nArr[i] = sc.nextInt();
			}
			
			// 0 0 0이 입력되면 종료
			if(nArr[0] == 0 && nArr[1] == 0 && nArr[2] == 0)break ;
			
			int max = Math.max(nArr[0], Math.max(nArr[1], nArr[2])) ;
			int sum = 0 ;
			
			for(int i=0; i<3; i++) {
				if(nArr[i] == max) continue ;
				
				sum += (nArr[i] * nArr[i]) ;
			}
			
			if(sum == (max * max)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
		
		sc.close();
		
	}

}
