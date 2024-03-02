import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int[] arr = new int [9] ;		// 아홉 명의 후보 난쟁이 키를 담아둘 배열 
		
		// 9명의 후보 난쟁이 키 입력 받기 
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt() ;
		}
		
		Arrays.sort(arr);			// 오름차순으로 정렬 (출력할 때 오름차순으로 출력해야 하므로)
		boolean[] pass = null ;		// 제외시킬 난쟁이를 기록하기 위한 배열 
		
		Allbreak : 
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				pass = new boolean [9] ;		// 초기화 
				pass[i] = true ;
				pass[j] = true ;			// 제외시킬 난쟁이를 true로 변경
					
				// 제외한 난쟁이를 뺴고 나머지 난쟁이의 키를 합산하여 100이 되는지 확인
				int sum = 0;
				for(int a=0; a<arr.length; a++) {
					if(pass[a] == false) sum += arr[a] ;
				}
					
				if(sum == 100) break Allbreak;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if (pass[i] == true) continue ;
			System.out.println(arr[i]);
		}
		
		sc.close();
		
	}

}
