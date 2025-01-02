import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 저장된 사이트 주소의 수
		int m = Integer.parseInt(st.nextToken());	// 비밀번호를 찾으려는 사이트 주소의 수
		
		HashMap<String, String> map = new HashMap<>();
		
		// HashMap에 사이트(key)와 비밀번호(value)를 저장
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		// 주어진 사이트에 맞는 비밀번호를 찾기
		for(int i=0; i<m; i++) {
			String key = br.readLine();
			bw.write(map.get(key)+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
