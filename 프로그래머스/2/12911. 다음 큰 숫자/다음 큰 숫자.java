import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n + 1;
        
        int count = Integer.bitCount(n);
        
        while(true) 
            if(Integer.bitCount(answer++) == count) 
                break;
        
        return answer - 1;
    }
}