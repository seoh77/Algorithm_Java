import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int release = calEndDay(progresses[0], speeds[0]);
        int cnt = 1;
        
        for(int i=1; i<progresses.length; i++) {
            int end = calEndDay(progresses[i], speeds[i]);
            
            if(end <= release) {
                cnt++;
            } else {
                answer.add(cnt);
                release = end;
                cnt = 1;
            }
        }
        
        answer.add(cnt);

        return listToArray(answer);
    }
    
    private int calEndDay(int progress, int speed) {
        return (int) Math.ceil((double)(100 - progress) / (double)speed);
    }
    
    private int[] listToArray(List<Integer> list) {
        int[] arr = new int [list.size()];
        
        for(int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
}