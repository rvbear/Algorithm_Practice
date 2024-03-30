import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] order = op.split(" ");
            
            if(order[0].equals("D") && min.size() < 1) {
                continue;
            }
            
            int value = Integer.parseInt(order[1]);
            
            if(order[0].equals("I")) {
                min.offer(value);
                max.offer(value);
                continue;
            }
            
            if(order[0].equals("D") && value == -1) {
                max.remove(min.poll());
            } else if(order[0].equals("D") && value == 1) {
                min.remove(max.poll());
            }
        }
        
        if(min.size() > 0) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}