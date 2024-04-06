import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int start = (int)begin, last = (int)end, index = 0;
        int[] answer = new int[last - start + 1];
        
        for(int i = start; i <= last; i++) {
            boolean flag = false;
            
            List<Integer> list = new ArrayList<>();
            
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    list.add(j);
                    if (i / j <= 10000000) {
                        answer[index++] = i / j;
                        flag = true;
                        break;
                    }
                }
             }
            
            if(flag) {
                continue;
            }
            
            if (!list.isEmpty()) {
                answer[index++] = list.get(list.size() - 1);
                continue;
            }

            answer[index++] = i == 1 ? 0 : 1;
        }
        
        return answer;
    }
}