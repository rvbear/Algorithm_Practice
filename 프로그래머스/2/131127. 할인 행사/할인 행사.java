import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean pass = false;
        
        for(int i = 0; i <= discount.length - 10; i++) {
            String[] arr = Arrays.copyOfRange(discount, i, i+10);
            boolean flag = false;
            
            if(!pass) {
                for(int j = 0; j < want.length; j++) {
                    int num = Collections.frequency(Arrays.asList(arr), want[j]);
                    if(number[j] != num) {
                        flag = true;
                        break;
                    }
                }
            } else {
                if(!discount[i-1].equals(arr[arr.length-1])) {
                    pass = false;
                    flag = true;
                }
            }
            
            if(!flag) {
                pass = true;
                answer++;
                continue;
            }
            
            answer += flag ? 0 : 1;
        }
        
        return answer;
    }
}