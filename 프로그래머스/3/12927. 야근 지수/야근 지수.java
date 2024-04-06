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
            pq.add(num == 0 ? 0 : num - 1);
        }
        
        for(int num : pq) {
            answer += (long)Math.pow((long)num, 2);
        }
        
        return answer;
    }
}