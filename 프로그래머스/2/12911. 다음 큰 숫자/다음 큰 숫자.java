import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        int count = Integer.bitCount(n);
        
        while(true) {
            int temp = Integer.bitCount(answer++);
            if(temp == count) break;
        }
        
        return answer - 1;
    }
}