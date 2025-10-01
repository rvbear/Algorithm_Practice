class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length][m];
        int INF = 120;
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = INF;
            }
        }
        
        dp[0][0] = info[0][0];
        if (info[0][1] < m) {
            dp[0][info[0][1]] = 0;
        }
        
        if (info.length == 1) {
            return info[0][1] < m ? 0 : info[0][0];
        }
        
        for (int i = 1; i < info.length; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + info[i][0]);
                if (j + info[i][1] < m) {
                    dp[i][j + info[i][1]] = Math.min(dp[i][j + info[i][1]], dp[i-1][j]);
                }
            }
        }
        
        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length - 1][i]);
        }
        
        return answer < n ? answer : -1;
    }
}
