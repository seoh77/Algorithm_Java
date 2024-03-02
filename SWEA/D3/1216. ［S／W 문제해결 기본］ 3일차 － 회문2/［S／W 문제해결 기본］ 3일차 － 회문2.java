import java.io.File;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
//		File file = new File("src/swea_1216_회문2/input.txt") ;
//		Scanner sc = new Scanner(file) ;
		
		Scanner sc = new Scanner(System.in) ;
		
		int T = 10;			// 총 10개의 테스트 케이스 
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			int testNum = sc.nextInt();		// 테스트 케이스 번호 
			
			String[][] arr = new String [100][100] ;		// 글자판 배열 (크기 100*100) 
			
			// 글자판 각 칸에 들어가있는 글자 입력받기 
			for(int r=0; r<arr.length; r++) {
				String[] str = sc.next().split("");
				for(int c=0; c<arr[r].length; c++) {
					arr[r][c] = str[c] ;
				}
			}
			
			int maxLen = 1;		// 가장 긴 회문의 길이 (한 글자만 있어도 길이 1인 회문이므로 초기값 1로 설정)
			
			// 가장 긴 회문 길이 탐색 (가로)
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr[r].length; c++) {
					
					int len = maxLen ;		// 탐색할 길이 설정 (maxLen보다 작은 경우는 굳이 탐색할 필요 없으므로 초기값 maxLen) 
					
					while(true) {
						if (c+len > arr.length) break ;		// 글자판 크기를 벗어났을 경우에는 break 
						
						boolean isPalindrome = true ;		// 회문인지 기록하기 위한 변수 
						
						// 길이만큼 문자열을 만들었을 때 i번째 글자와 뒤에서 i번째 글자가 같은지 비교 
						for(int i=0; i<len; i++) {
							int startC = c+i ;
							int endC = c+len-i-1 ;
							
							if(!arr[r][startC].equals(arr[r][endC])) {
								isPalindrome = false ;	// 같지 않을 경우 회문이 아니므로 isPalindrome 값 변
								break ;					// 더 이상 해당 문자 길이는 탐색할 필요 없음 
							}
						}
						
						// 해당 길이의 문자열이 회문일 경우 maxLen를 비교해서 최댓값 갱신 
						if(isPalindrome) maxLen = (len > maxLen) ? len : maxLen ;
						
						len++ ;		// 길이를 늘려서 다시 회문인지 탐색 
					}
					
				}
			}
			
			// 가장 긴 회문 길이 탐색 (세로)
			for(int c=0; c<arr.length; c++) {
				for(int r=0; r<arr.length; r++) {
					
					int len = maxLen ;
					
					while(true) {
						if(r+len > arr.length) break ;
						
						boolean isPalindrome = true ;
						
						for(int i=0; i<len; i++) {
							int startR = r+i ;
							int endR = r+len-i-1 ;
							
							if(!arr[startR][c].equals(arr[endR][c])) {
								isPalindrome = false ;
								break ;
							}
						}
						
						if(isPalindrome) maxLen = (len > maxLen) ? len : maxLen ;
						
						len++ ;
					}
					
				}
			}
			
			System.out.printf("#%d %d\n", test_case, maxLen);
			
		}
		
		sc.close();
		
	}

}
