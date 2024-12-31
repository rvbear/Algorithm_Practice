import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> num = new ArrayList<>();
        
        long f = 1;
        for(int i = 1; i <= n; i++) {
            num.add(i);
            f *= i;
        }
        
        k--;
        int index = 0;
        while(index < n) {
            f /= n - index;
            answer[index++] = num.remove((int) (k / f));
            k %= f;
        }
        
        return answer;
    }
}