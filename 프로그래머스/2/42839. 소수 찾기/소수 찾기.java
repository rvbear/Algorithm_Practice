import java.util.*;

class Solution {
    Set<Integer> set;
    boolean[] visit;
    public boolean isPrime(int n) {
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return (n < 2) ? false : true;
    }
    public void dfs(String numbers, String temp, int depth) {
        if(depth == numbers.length()) {
            return;
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                set.add(Integer.parseInt(temp + numbers.charAt(i)));
                dfs(numbers, temp + numbers.charAt(i), depth + 1);
                visit[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean[numbers.length()];
        set = new HashSet<>();
        
        dfs(numbers, "", 0);
        
        for(int num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
}