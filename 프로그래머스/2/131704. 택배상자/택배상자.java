import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1, j = 0; i <= order.length; i++) {
            stack.add(i);
            while(!stack.isEmpty() && stack.peek() == order[j]) {
                stack.pop();
                answer++;
                j++;
            }
        }
        
        return answer;
    }
}