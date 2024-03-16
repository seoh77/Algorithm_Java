import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.List ;
import java.util.ArrayList ;
import java.util.Collections;

 public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> entrySet = new HashSet<>();
		
		for (int i=0; i<n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken() ;
			String entry = st.nextToken() ;
			
			if (entry.equals("enter")) entrySet.add(name) ;
			else if (entry.equals("leave")) {
				if (entrySet.contains(name)) entrySet.remove(name);
			}
			
		}
		
		List<String> entryList = new ArrayList<>(entrySet);
		Collections.sort(entryList, Collections.reverseOrder() );
		
		for (int i=0; i<entryList.size(); i++) {
			bw.write(entryList.get(i)+"\n");
		}
		
		bw.close();
		br.close();
		
	}
}