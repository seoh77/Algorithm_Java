import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Num> numbers;
	
	static class Num {
		int v;		// 숫자 값
		int n = 1;	// 숫자의 개수 (기본값 1)
		
		Num(int v) {
			this.v = v;
		}
	}
	
	// 오름차순으로 숫자를 정렬
	static class NumberComparator implements Comparator<Num> {
		@Override
		public int compare(Num o1, Num o2) {
			if(o1.v > o2.v) {
				return 1;
			} else if (o1.v < o2.v) {
				return -1;
			}
			return 0;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());	// N개의 자연수
		int m = Integer.parseInt(st.nextToken());	// M개를 선택
		
		
		numbers = new ArrayList<>();		// N개의 자연수를 저장한 리스트
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			int inputNum = Integer.parseInt(st.nextToken());
			int idx = numberIdx(inputNum);
			
			if(idx == -1) {
				// 새로 나온 숫자라면 numbers 리스트에 추가
				numbers.add(new Num(inputNum));
			} else {
				// 앞서 나왔던 숫자라면 Num.n 크기만 +1 
				numbers.get(idx).n += 1;
			}
		}
		
		// 오름차순 정렬
		Collections.sort(numbers, new NumberComparator());
		
		selectNum(0, new int[m]);
	}
	
	/**
	 * 입력된 숫자 N이 numbers 배열에 이미 있는 수라면 idx를 반환
	 * @param n 입력받은 숫자
	 * @return numbers에서의 idx 번호 (-1일 경우 numbers 배열에 없는 숫자)
	 */
	public static int numberIdx(int n) {
		for(int i=0; i<numbers.size(); i++) {
			if(numbers.get(i).v == n) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * 숫자를 선택하는 메소드
	 * @param idx	몇 번째 idx의 숫자를 결정하는지
	 * @param answer	현재까지 만들어진 수열
	 */
	public static void selectNum (int idx, int[] answer) {
		if(idx >= answer.length) {
			print(answer);
			return;
		}
		
		for(int i=0; i<numbers.size(); i++) {
			if(numbers.get(i).n <= 0) continue;
			
			answer[idx] = numbers.get(i).v;
			numbers.get(i).n -= 1;
			selectNum(idx+1, answer);
			numbers.get(i).n += 1;
		}
	}
	
	/**
	 * 출력을 위한 메소드
	 * @param answer 완성된 수열
	 */
	public static void print(int[] answer) {
		for(int n : answer) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
