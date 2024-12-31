import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        
        for(int i = prices.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= prices[i]) {
                stack.pop();
                index.pop();
            }
            
            if(!stack.isEmpty()) {
                answer[i] = index.peek() - i;
            } else {
                answer[i] = prices.length - 1 - i;
            }
            
            stack.push(prices[i]);
            index.push(i);
        }
        
        return answer;
    }
}