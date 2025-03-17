import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {
        // 1. 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 2. 계산
        int answer = 0;
        int len = A.length;
        
        for(int i=0; i<len; i++) {
            answer += (A[i] * B[len-1-i]);
        }

        return answer;
    }
}