import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i <= discount.length - 10; i++) {
            String[] arr = Arrays.copyOfRange(discount,i,i+10);
            boolean flag = false;
            for(int j = 0; j < want.length; j++) {
                int num = Collections.frequency(Arrays.asList(arr), want[j]);
                if(number[j] > num) {
                    flag = true;
                    break;
                }
            }
            answer += flag ? 0 : 1;
        }
        
        return answer;
    }
}