import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        int n = strArr.length;
        
        int[] nums = new int [n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(nums);
        
        String min = nums[0] + "";
        String max = nums[nums.length-1] + "";
        
        String answer = min + " " + max ;
        return answer;
    }
}