import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        
        int end = targets[0][1];
        answer++;
        
        for(int[] temp : targets) {
            if(temp[0] >= end) {
                end = temp[1];
                answer++;
            }
        }
        
        return answer;
    }
}