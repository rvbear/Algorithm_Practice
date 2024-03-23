import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length, soldier = n, skill = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++) {
            soldier -= enemy[i];
            pq.add(enemy[i]);
            
            if(soldier < 0) {
                if(skill > 0 && !pq.isEmpty()) {
                    soldier += pq.poll();
                    skill--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}