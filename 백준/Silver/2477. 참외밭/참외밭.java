import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int K = sc.nextInt();			// 1제곱미터의 넓이에 자라는 참외의 개수 
		
		int[] arr = new int [6] ;		// 육각형 변의 길이를 저장하는 배열 
		int widthMax = 0 ;				// 가로 길이 중 최댓값
		int heightMax = 0 ;				// 세로 길이 중 최댓값 
		
		for(int i=0; i<arr.length; i++) {
			int move = sc.nextInt();		// 방향
			arr[i] = sc.nextInt();			// 길이
			// 최댓값 갱신
			if (move == 3 || move == 4) {
				widthMax = (arr[i] > widthMax) ? arr[i] : widthMax ;
			} else if (move == 1 || move == 2) {
				heightMax = (arr[i] > heightMax) ? arr[i] : heightMax ;
			}
		}
		
		// 가장 긴 세로 (heightMax)
		// 가장 긴 세로의 양쪽에 있는 가로 중 가장 긴 가로가 아닌 것 (w)
		// 가장 긴 가로 (widthMax)
		// 가장 긴 가로의 양쪽에 있는 세로 중 가장 긴 세로가 아닌 것 (h)
		// 참외밭 크기 = (heightMax * w) + ((widthMax - w) * h)
		
		// w와 h 구하기
		int w = 0 ;
		int h = 0 ;
		for(int i=0; i<arr.length; i++) {
			// 가장 긴 세로의 양쪽에 있는 가로 중 가장 긴 가로가 아닌 것 (w)
			if(arr[i] == heightMax) {
				int leftIdx = (i == 0) ? arr.length-1 : i-1 ;
				int rightIdx = (i == arr.length-1) ? 0 : i+1 ;
				
				if (arr[leftIdx] != widthMax) w = arr[leftIdx] ;
				else w = arr[rightIdx] ;
			}
			
			// 가장 긴 가로의 양쪽에 있는 세로 중 가장 긴 세로가 아닌 것 (h)
			if(arr[i] == widthMax) {
				int leftIdx = (i == 0) ? arr.length-1 : i-1 ;
				int rightIdx = (i == arr.length-1) ? 0 : i+1 ;
				
				if (arr[leftIdx] != heightMax) h = arr[leftIdx] ;
				else h = arr[rightIdx] ;
			}
		}
		
		// 참외밭 크기 구하기
		int area = (heightMax * w) + ((widthMax - w) * h) ;
		
		// 참외의 수 구하기 
		int num = area * K ;
		
		System.out.println(num);
		
		sc.close();
		
	}

}
