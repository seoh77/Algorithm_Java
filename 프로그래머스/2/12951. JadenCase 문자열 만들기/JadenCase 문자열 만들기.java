class Solution {
    public String solution(String s) {
        String answer = "";
		boolean isUpper = true;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(isUpper) {
				answer += String.valueOf(s.charAt(i)).toUpperCase();
				isUpper = false;
			} else {
			    answer += String.valueOf(s.charAt(i)).toLowerCase();
            }

			if(c == ' ') {
				isUpper = true;
			}
		}
        
        return answer;
    }
}