import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> node = new HashMap<>();
        int[] answer = {0, 0, 0, 0};
        
        for(int[] edge : edges) {
            int outNode = edge[0];
            int inNode = edge[1];
            
            if(!node.containsKey(outNode)) {
                node.put(outNode, new int[] {0, 0});
            }
            if(!node.containsKey(inNode)) {
                node.put(inNode, new int[] {0, 0});
            }
            
            node.get(outNode)[0]++;
            node.get(inNode)[1]++;
        }
        
        for(int key : node.keySet()) {
            int[] count = node.get(key);
            
            if(count[0] >= 2 && count[1] == 0) {
                answer[0] = key;
            } else if(count[0] == 0 && count[1] > 0) {
                answer[2]++;
            } else if(count[0] >= 2 && count[1] >= 2) {
                answer[3]++;
            }
        }
        
        answer[1] = node.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}