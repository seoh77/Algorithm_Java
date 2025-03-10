import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long total = calTotal(price, count);
        
        if(money >= total) {
            return 0;
        }
        
        return Math.abs(money - total);
    }
    
    public long calTotal(int price, int count) {
        long total = 0;
        
        for(int i=1; i<=count; i++) {
            total += (price * i);
        }
        
        return total;
    }
}