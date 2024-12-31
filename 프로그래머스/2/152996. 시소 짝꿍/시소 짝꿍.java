import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long temp = 0;
        Arrays.sort(weights);
        
        for(int i = 0; i < weights.length - 1; i++) {
            if(i != 0 && weights[i-1] == weights[i]) {
                answer += --temp;
                continue;
            }
            temp = 0;
            for(int j = i + 1; j < weights.length; j++) {
                if(weights[i] == weights[j]
                  || weights[i] * 2 == weights[j]
                  || weights[i] * 3 == weights[j] * 2
                  || weights[i] * 4 == weights[j] * 3) {
                    temp++;
                }
            }
            answer += temp;
        }
        
        return answer;
    }
}