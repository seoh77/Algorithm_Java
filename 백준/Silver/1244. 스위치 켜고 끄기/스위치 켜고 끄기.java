import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();		// 스위치 개수 
		int[] arr = new int [N] ;	// 스위치 상태 값을 담을 배열 
		
		// 스위치 상태 입력
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt() ;
		}
		
		int person = sc.nextInt(); 	    // 학생수
		
		for(int p=0; p<person; p++) {
			
			int gender = sc.nextInt();		// 성별 (남자 : 1, 여자 : 2)
			int idx = sc.nextInt();         // 학생이 받은 수
			
			// 남학생이라면 자기가 받은 수의 배수 스위치의 상태를 바꿈
			if (gender == 1) {
				for(int i=0; i<arr.length; i++) {
					if ((i+1) % idx == 0) {
						arr[i] = (arr[i] == 0) ? 1 : 0 ;
					}
				}
			}
			
			// 여학생이라면 자기가 받은 수를 기준으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아, 그 구간에 속한 스위치 상태를 모두 바꿈
			else if (gender == 2) {
				int maxLen = 0 ;
				int num = 1;
				
				idx -= 1 ;			// idx 번호는 0번부터 시작하므로 1을 빼줌 
				
				// 대칭인 구간 찾기 
				while(true) {
					if(idx-num < 0 || idx+num >= arr.length) break ;
					if (arr[idx-num] != arr[idx+num]) break ;
					
					maxLen = num ;
					num++ ;
					
				}
				
				// 구간에 속한 스위치 상태를 모두 바꿈 
				for(int i=idx-maxLen; i<=idx+maxLen; i++) {
					arr[i] = (arr[i] == 0) ? 1 : 0 ;
				}
				
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			if ((i+1) % 20 == 0) System.out.println();
		}
		
		sc.close(); 
		
	}

}
