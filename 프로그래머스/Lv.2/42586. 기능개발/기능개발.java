import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        
        int max = 0;
        for(int i = 0; i < progresses.length; i++) {
            int temp = (100 - progresses[i]) / speeds[i];
            temp += (100 - progresses[i]) % speeds[i] > 0 ? 1 : 0; 
            if(max < temp) {
                max = temp;
            }
            answer[max]++;
        }
        
        return Arrays.stream(answer).filter(i -> i != 0).toArray();
    }
}