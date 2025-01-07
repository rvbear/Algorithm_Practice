class Solution {
    int[][] dp;
    int[] solve(int n) {
        if(dp[n][0] == Integer.MAX_VALUE) {
            if(n >= 50) {
                int[] temp = solve(n - 50);
                if((temp[0] + 1 < dp[n][0]) || ((temp[0] + 1 == dp[n][0]) && (temp[1] + 1 > dp[n][1]))) {
                    dp[n][0] = temp[0] + 1;
                    dp[n][1] = temp[1] + 1;
                }
            }
            
            int start = n >= 20 ? 20 : n;
            for(int i = start; i >= 1; i--) {
                for(int j = 1; j <= 3; j++) {
                    if(n >= i * j) {
                        int[] temp = solve(n - i * j);
                        int cnt = j == 1 ? 1 : 0;
                        if(temp[0] + 1 < dp[n][0] || (temp[0] + 1 == dp[n][0] && (temp[1] + cnt > dp[n][1]))) {
                            dp[n][0] = temp[0] + 1;
                            dp[n][1] = temp[1] + cnt;
                        }
                    }
                }
            }
        }
        
        return dp[n];
    }
    public int[] solution(int target) {
        int[] answer = new int[2];
        dp = new int[target+1][2];
        
        for(int i = 1; i < target+1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        
        return solve(target);
    }
}