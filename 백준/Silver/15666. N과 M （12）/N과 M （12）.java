import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int m;
	static List<Integer> nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());	// N개의 자연수
		m = Integer.parseInt(st.nextToken());		// M개를 선택
		
		nums = new ArrayList<Integer>();		// 수열을 만들 때 사용할 수 있는 숫자 관리
		
		// 수열을 만들 때 사용할 수 있는 숫자 넣기
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!check(num)) {
				nums.add(num);
			}
		}
		
		// 오름차순 정렬
		Collections.sort(nums);
		
		// 수열 만들기
		int[] arr = new int [m];	// 만들어진 수열을 저장하는 배열
		combi(0, arr);
	}
	
	/**
	 * 이미 nums 배열에 포함된 숫자인지 중복 확인
	 */
	public static boolean check(int num) {
		for(int n : nums) {
			if(n == num) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 수열을 만드는 메소드
	 */
	public static void combi(int idx, int[] arr) {
		if(idx >= m) {
			print(arr);
			return;
		}
		
		for(int n : nums) {
			// 중복되는 수열을 만들지 않게 하기 위한 조건
			if(idx != 0 && n < arr[idx-1]) continue;
			
			arr[idx] = n;
			combi(idx + 1, arr);
		}
	}
	
	/**
	 * 만들어진 수열을 출력하는 메소드
	 */
	public static void print(int[] arr) {
		for(int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
