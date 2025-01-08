import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] arr;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 연산의 개수
		arr = new int [n+1];
		size = 0;
		
		for(int i=1; i<=n; i++) {
			int x = Integer.parseInt(br.readLine());	// 연산에 대한 정보
			
			// x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거
			if(x == 0) {
				int removeNum = remove();
				System.out.println(removeNum);
			} else {
				// x가 자연수라면 배열에 x라는 값을 추가
				insert(x);
			}
		}
	}
	
	/**
	 * 배열에 자연수 x를 추가하는 메소드
	 * @param x 배열에 추가하고자 하는 자연수
	 */
	public static void insert(int x) {
		// 배열의 마지막 자리에 x 넣기
		size++;
		int idx = size;
		arr[idx] = x;
		
		// 새로 추가한 자연수 x의 위치가 1보다 크고, 부모가 자식보다 값이 크다면 위치 교환
		while (idx > 1 && (arr[idx/2] > arr[idx])) {
			int temp = arr[idx/2];	// 부모 노드의 값
			arr[idx/2] = x;
			arr[idx] = temp;
			
			idx /= 2;
		}
	}
	
	/**
	 * 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거하는 메소드
	 * @return 배열에서 가장 작은 값
	 */
	public static int remove() {
		// 배열이 비어 있는 경우라면 0을 출력
		if(size == 0) {
			return 0;
		}
		
		int removeNum = arr[1];		// 첫번째 요소 값 (최솟값)
		
		// 마지막 노드를 root에 삽입하고 마지막 노드 삭제
		arr[1] = arr[size];
		arr[size] = 0;
		size -= 1;

		int idx = 1;	// 루트에 새로 삽입한 노드의 인덱스 정보
		
		// (idx * 2)는 왼쪽 자식의 인덱스 값으로, 자식의 인덱스 값이 배열의 사이즈보다 크다는 것은 삽입할 위치를 벗어났다는 뜻
		while((idx * 2) <= size) {
			int minIdx = idx * 2;		// 왼쪽 자식 인덱스 (idx * 2)
			int min = arr[minIdx];		// 왼쪽 자식의 값
			
			// 오른쪽 자식의 인덱스가 사이즈보다 작고, 왼쪽보다도 더 작은 경우
			if((idx * 2 + 1) <= size && min > arr[idx * 2 + 1]) {
				minIdx = idx * 2 + 1;
				min = arr[minIdx];
			}
			
			// 부모의 값이 더 작으면 교환할 필요X
			if(arr[idx] <= min) break;
			
			// 부모의 값이 더 클 경우 교환O
			arr[minIdx] = arr[idx];
			arr[idx] = min;
			
			idx = minIdx;
		}
		
		return removeNum;
	}
}
