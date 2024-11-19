import java.util.*;

class Solution {
    public static int maxSign = 0;
    public static int maxCost = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int n = users.length;
        find(0, emoticons.length, new int[emoticons.length], users, emoticons);
        return new int[] {maxSign, maxCost};
    }
    
    public void find(int r, int m, int[] discount, int[][] users, int[] emoticons) {
        if(r == m) {
            int sign = 0, cost = 0;
            
            for(int[] user : users) {
                int userRate = user[0];
                int userCost = user[1];
                
                int sum = 0;
                
                for(int i = 0; i < m; i++) {
                    if(discount[i] >= userRate) {
                        sum += emoticons[i] / 100 * (100 - discount[i]);
                    }
                }
                if(sum >= userCost) {
                    sign++;
                } else {
                    cost += sum;
                }
            }
            
            if(sign > maxSign) {
                maxSign = sign;
                maxCost = cost;
            } else if(sign == maxSign) {
                maxCost = Math.max(cost, maxCost);
            }
            return;
        }
        
        for(int i = 10; i <= 40; i += 10) {
            discount[r] = i;
            find(r+1, m, discount, users, emoticons);
        }
    }
}