import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

 public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) ;
		int M = Integer.parseInt(st.nextToken()) ;
		
		HashMap<String,String> pokemon = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String name = br.readLine();
            String number = Integer.toString(i+1);
            pokemon.put(name, number);
            pokemon.put(number, name);
		}
		
		for (int i=0; i<M; i++) {
			String question = br.readLine() ;
			bw.write(pokemon.get(question)+"\n");
		}
		
		bw.close();
		br.close();
		
	}
}