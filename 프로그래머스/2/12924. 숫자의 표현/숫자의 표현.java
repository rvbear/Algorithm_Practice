class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1; i <= n/2; i++) {
            int temp = i;
            for(int j = i+1; j <= n/2 + 1; j++) {
                temp += j;
                if(temp < n) continue;
                else if(temp == n) answer++;
                break;
            }
        }
        
        return answer;
    }
}