import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        for(int i = people.length - 1, j = 0; i >= j; i--) {
            if(people[i] + people[j] <= limit) {
                j++;
            }
            answer++;
        }
        
        return answer;
    }
}