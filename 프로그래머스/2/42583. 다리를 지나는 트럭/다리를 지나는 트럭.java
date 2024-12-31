import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        if(bridge_length == 1) {
            return truck_weights.length + 1;
        } else if(truck_weights.length == 1) {
            return bridge_length + 1;
        }
        
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int index = 0, sumWeight = 0;
        
        while(index < truck_weights.length) {
            sumWeight -= bridge.poll();
            answer++;
            
            if(sumWeight + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                sumWeight += truck_weights[index++];
            } else {
                bridge.offer(0);
            }
        }
        
        return answer + bridge_length;
    }
}
