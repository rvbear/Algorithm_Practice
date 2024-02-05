import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int num : scoville) {
            q.add(num);
        }
        
        while(q.peek() < K) {
            if(q.size() == 1) {
                answer = -1;
                break;
            }
            q.add(q.poll() + q.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}
