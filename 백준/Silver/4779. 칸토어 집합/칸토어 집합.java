import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb ;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		
		String str ;
		
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str) ;
			int len = (int) Math.pow(3, N) ;	// 3^n 계산
			
			sb = new StringBuilder() ;
			
			for(int i=0; i<len; i++) {
				sb.append("-") ;
			}
			
			change(0, len) ;
			
			// 결과 출력
			System.out.println(sb);
		}
		
	}
	
	public static void change(int start, int size) {
		
		if(size == 1) return ;
		
		int div = size / 3 ;			// 3등분
		
		// 가운데 영역 공백으로 바꾸기
		for(int i=start+div; i<start+2*div; i++) {
			sb.setCharAt(i, ' ');
		}
		
		change(start, div) ;
		change(start+2*div , div) ;
		
	}
}
