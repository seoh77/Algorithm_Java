import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Clothes {
		String type;
		int num;
		
		Clothes(String type, int num) {
			this.type = type;
			this.num = num;
		}
	}
	
	static List<Clothes> list;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0; t<TC; t++) {
			int n = Integer.parseInt(br.readLine());	// 의상의 수
			list = new ArrayList<Clothes>();	// 가지고 있는 의상 종류와 수량을 저장한 list
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();	// 의상 이름
				String type = st.nextToken();	// 의상 종류
				
				containList(type);
			}
			
			int answer = 1;
			for(int i=0; i<list.size(); i++) {
				answer *= (list.get(i).num + 1);	// 가지고 있는 의상 중에 선택할 수 있는 경우 + 해당 종류의 의상을 입지 않는 경우
			}
			
			System.out.println(answer - 1);
		}
		
	}
	
	/**
	 * list에 의상종류(Type)가 포함되어 있는지 확인한 후 처리
	 * @param type 의상 종류
	 */
	public static void containList(String type) {
		for(int i=0; i<list.size(); i++) {
			Clothes clothes = list.get(i);
			
			// list에 type이 이미 저장되어 있었다면 수량만 +1
			if(type.equals(clothes.type)) {
				clothes.num += 1;
				return;
			}
		}
		
		// list에 해당 type이 없었다면 새로 추가
		list.add(new Clothes(type, 1));
	}
}
