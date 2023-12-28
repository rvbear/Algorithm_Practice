import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0, d = 0, p = 0;
        
        for(int i = n-1; i >= 0; i--) {
            int count = 0;
            
            d -= deliveries[i];
            p -= pickups[i];
            
            while(d < 0 || p < 0) {
                d += cap;
                p += cap;
                count += 1;
            }
            
            answer += (i+1) * 2 * count;
        }
        
        return answer;
    }
}