class Solution {
    public int[] solution(int[] arr) {
        // 가장 작은 수를 제거했을 경우 빈 배열이라면 빈 배열에 -1을 넣어 리턴
        if(arr.length <= 1) {
            return new int[]{-1};
        }
        
        int min = findMin(arr);
        int[] answer = remove(arr, min);
        
        return answer;
    }
    
    /**
        입력받은 배열에서 가장 작은 수 찾기
    */
    public int findMin(int[] arr) {
        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
    
    /**
        입력받은 배열에서 removeNum을 제거하고 리턴
    */
    public int[] remove(int[] arr, int removeNum) {
        int[] answer = new int [arr.length - 1];
        int idx = 0;
        for(int n : arr) {
            if(n == removeNum) continue;
            answer[idx++] = n;
        }
        return answer;
    }
}