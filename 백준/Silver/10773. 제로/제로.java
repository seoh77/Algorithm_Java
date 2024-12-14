import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		List<Integer> nums = new ArrayList<>();
		
		for(int i=0; i<k; i++) {
			int num = sc.nextInt();
			
			if(num == 0) {
				nums.remove(nums.size()-1);
				continue;
			}
			
			nums.add(num);
		}
		
		int sum = 0;
		
		for(int i=0; i<nums.size(); i++) {
			sum += nums.get(i);
		}
		
		System.out.println(sum);
		
		sc.close();
		
	}

}
