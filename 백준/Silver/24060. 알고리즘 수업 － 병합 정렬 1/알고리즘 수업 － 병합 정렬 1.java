import java.util.Scanner;

public class Main {
	
	static int[] arr ;
	static int[] sortedArr ;
	static int K ; 
	static int count = 0 ;
	static int result = -1;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int N = sc.nextInt();			// 배열 A의 크기
		arr = new int [N] ;				// 배열 A
		sortedArr = new int [N] ;
		K = sc.nextInt();				// 저장 횟수
		
		// 배열 A의 원소 입력
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(0, arr.length-1) ;
		System.out.println(result);
		
		sc.close();
		
	}
	
	public static void mergeSort(int startIdx, int endIdx) {
		if (startIdx >= endIdx) return;
		
		int midIdx = (startIdx + endIdx) / 2 ;
		
		mergeSort(startIdx, midIdx) ;
		mergeSort(midIdx+1, endIdx) ;
		merge(startIdx, midIdx, endIdx) ;
	}
	
	public static void merge(int startIdx, int midIdx, int endIdx) {
		int left = startIdx ;		// 왼쪽 구간의 시작 포인트
		int right = midIdx + 1 ;	// 오른쪽 구간의 시작 포인트
		int idx = left ;			// 정렬된 원소 저장할 위치
		
		// 아직 비교할 수 있는 값들이 남아있을 때
		while(left <= midIdx && right <= endIdx) {
			if (arr[left] <= arr[right]) sortedArr[idx++] = arr[left++] ;
			else sortedArr[idx++] = arr[right++] ;
		}
		
		// 왼쪽 구간만 남아있을 때
		if (left <= midIdx) {
			for(int i=left; i<=midIdx; i++) {
				sortedArr[idx++] = arr[i] ;
			}
		}
		
		// 오른쪽 구간만 남아있을 때
		else {
			for(int i=right; i<=endIdx; i++) {
				sortedArr[idx++] = arr[i] ;
			}
		}
		
		// 마지막으로 원본에 반영하기
		for(int i=startIdx; i<=endIdx; i++) {
			arr[i] = sortedArr[i] ;
			if (++count == K) {
				result = arr[i] ;
				return ;
			}
		}
		
	}
 
}
