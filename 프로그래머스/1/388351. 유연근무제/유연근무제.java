class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            // 지각한 적이 없는 직원들 수 세기
            if(!isLate(schedules[i], timelogs[i], startday)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    /**
        해당 직원이 지각한 적이 있는지 확인
    */
    private boolean isLate(int schedule, int[] timelog, int day) {
        int lastTime = getLastTime(schedule);
        
        for(int time : timelog) {
            // 토요일, 일요일은 pass
            if(day == 6 || day == 7) {
                day = (day == 7) ? 1 : day + 1;
                continue;
            }
            
            // 출근 희망 시각 + 10분보다 늦게 출근했을 경우 지각
            if(time > lastTime) {
                return true;
            }
            
            day++;
        }
        
        return false;
    }
    
    /**
        출근 희망 시각 + 10분 계산
    */
    private int getLastTime(int schedule) {
        schedule += 10;
        
        if(schedule % 100 >= 60) {
            int h = (schedule / 100) + 1;
            int m = (schedule % 100) - 60;
            schedule = (h * 100) + m;
        }
        
        return schedule;
    }
}