import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

 public class Main {

	 private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 static int N, M;
	 static int getNum[];
	
	public static void main(String[] args) throws IOException {
        
		StringTokenizer st ;
		
		// 가지고 있는 숫자카드 배열에 집어넣기 
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		getNum = new int [N] ;
		for (int i=0; i<getNum.length; i++) {
			getNum[i] = Integer.parseInt(st.nextToken());
		}
		
		// 가지고 있는 숫자 카드를 오름차순으로 정렬 
		Arrays.sort(getNum);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<M; i++) {
			int searchNum = Integer.parseInt(st.nextToken());
			
			// 이분 탐색을 해서 해당 숫자가 있는 경우
            if(binarySearch(searchNum)) bw.write("1 ");
            // 이분 탐색을 해서 해당 숫자가 없는 경우
            else bw.write("0 ");
			
		}
		
		bw.close();
		br.close();
		
	}
	
	private static boolean binarySearch (int searchNum) {
		int leftIndex = 0;
		int rightIndex = getNum.length -1 ;

    	while(leftIndex <= rightIndex){
    		int midIndex = (leftIndex + rightIndex) / 2;
    		int mid = getNum[midIndex];

    		if(mid < searchNum) leftIndex = midIndex + 1;
    		else if(mid > searchNum) rightIndex = midIndex - 1;
    		else return true;
    	}
    	
    	return false;
	}
	
}