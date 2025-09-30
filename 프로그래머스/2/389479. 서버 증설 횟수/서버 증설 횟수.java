class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int answer = 0;
        
        for (int i = 0; i < 24; i++) {
            int needServer = 0;
            if (players[i] >= m) {
                needServer += ((players[i] - m) / m) + 1;
            }
            
            int serverCnt = 0;
            for (int j = Math.max(0, i - k + 1); j < i; j++) {
                serverCnt += server[j];
            }
            
            int add = Math.max(0, needServer - serverCnt);
            server[i] = add;
            answer += add;
        }
        
        return answer;
    }
}