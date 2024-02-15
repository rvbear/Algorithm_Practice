import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1, j = 0; i <= order.length; i++) {
            boolean flag = false;
            if(order[j] == i) {
                answer++;
                j++;
                flag = true;
            }
            while(!stack.isEmpty() && stack.peek() == order[j]) {
                stack.pop();
                answer++;
                j++;
            }
            if(!flag) {
                stack.add(i);
            }
        }
        /*
        1 2 3 4 5
        1  2345
        12 345
        123 45
        4 123 5
        43 12 5
        */  
        return answer;
    }
}