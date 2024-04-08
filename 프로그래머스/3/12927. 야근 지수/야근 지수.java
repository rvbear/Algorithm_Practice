import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
            pq.add(work);
        }
        
        for(int i = 0; i < n; i++) {
            int num = pq.poll();
            if(num == 0) {
                break;
            }
            pq.add(num - 1);
        }
        
        for(int num : pq) {
            answer += (long)Math.pow((long)num, 2);
        }
        
        return answer;
    }
}