import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Set<Integer> right = new HashSet<>();
        
        for(int t : topping) {
            left.put(t, left.getOrDefault(t, 0) + 1);
        }
        
        for(int t : topping) {
            left.put(t, left.get(t) - 1);
            right.add(t);
            
            if(left.get(t) == 0) {
                left.remove(t);
            }
            
            if(left.size() == right.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}