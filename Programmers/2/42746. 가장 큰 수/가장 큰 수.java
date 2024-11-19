import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] answer = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(answer, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        return answer[0].equals("0") ? "0" : String.join("", answer);
    }
}