import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());	// 테스트 케이스의 수
		
		for(int t=1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// n개의 정수들
			int k = Integer.parseInt(st.nextToken());	// 두 정수의 합이 k에 가장 가까워야 함
			int[] nArr = new int [n];	// n개의 정수를 저장한 배열
			
			// n개의 정수 입력
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				nArr[i] = Integer.parseInt(st.nextToken());
			}
			
			int minGap = Integer.MAX_VALUE;	// k와의 차이 최솟값
			int cnt = 0;					// 조합의 수
			
			// 투포인터 활용
			int left = 0;			// 왼쪽 인덱스
			int right = n-1;		// 오른쪽 인덱스
			Arrays.sort(nArr);		// 정렬
			
			while(left < right) {
				int sum = nArr[left] + nArr[right];	// 두 정수의 합
				int gap = Math.abs(k-sum);			// k와의 간격 차이
				
				// gap이 minGap보다 작다면 minGap 값을 갱신하고 cnt 값도 1로 초기화
				if(gap < minGap) {
					minGap = gap;
					cnt = 1;
				} else if (gap == minGap) {
					// gap과 minGap이 같다면 cnt 1 증가
					cnt++;
				}
				
				// sum 값이 k보다 작다면 값을 증가시키기 위해 left를 1 증가
				if(sum < k) {
					left++;
				} else {
					// sum 값이 k보다 작거나 같다면 값을 감소시키기 위해 right 1 감소
					right--;
				}
			}
			
			System.out.println(cnt);
			
		}
		
	}
}
