import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        
        for(int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int profit = 100 * amount[i];
            
            while(!now.equals("-")) {
                int giveProfit = profit / 10;
                int nowProfit = profit - giveProfit;
                
                answer[index.get(now)] += nowProfit;
                now = parent.get(now);
                profit /= 10;
                
                if(profit < 1) {
                    break;
                }
            }
        }
        
        return answer;
    }
}