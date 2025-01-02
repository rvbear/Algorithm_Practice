import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        int n = lottos.length, m = winNums.length;
        int zeroCnt = 0;
        int score = 0;
        Set<Integer> win = new HashSet<>();
        
        for(int winNum : winNums) {
            win.add(winNum);
        }
        
        for(int i = 0; i < n; i++) {
            if(lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            
            if(win.contains(lottos[i])) {
                score++;
            }
        }
        
        int min = 7 - score > 5 ? 6 : 7 - score;
        int max = 7 - (score + zeroCnt) > 5 ? 6 : 7 - (score + zeroCnt);
        
        return new int[] {max, min};
    }
}