class Solution {
    public int solution(int n) {
        int answer = n > 1 ? n+1 : n;
        
        for(int i = 2; i < n; i++)
            if(n % i == 0) answer += i;
        
        return answer;
    }
}