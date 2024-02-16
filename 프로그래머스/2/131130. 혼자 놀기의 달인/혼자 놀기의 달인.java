import java.util.*;

class Solution {
    boolean[] visit;
    PriorityQueue<Integer> queue;
    
    public void dfs(int[] cards, int index, int depth) {
        if(visit[index]) {
            queue.add(depth);
            return;
        }
        
        visit[index] = true;
        dfs(cards, cards[index] - 1, depth + 1);
    }
    
    public int solution(int[] cards) {
        int answer = 0;
        visit = new boolean[cards.length];
        queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < cards.length; i++) {
            if(!visit[i]) {
                dfs(cards, i, 0);
            }
        }
        
        return answer = queue.size() == 1 ? 0 : queue.poll() * queue.poll();
    }
}