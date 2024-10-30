class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int k = 1000 * 100;
        t1 += 10;
        t2 += 10;
        temperature += 10;
        int[][] dp = new int[onboard.length][51];
        
        for(int i = 0; i < onboard.length; i++) {
            for(int j = 0; j < 51; j++) {
                dp[i][j] = k;
            }
        }
        
        dp[0][temperature] = 0;
        
        int flag = temperature > t2 ? -1 : 1;
        
        for(int i = 1; i < onboard.length; i++) {
            for(int j = 0; j < 51; j++) {
                int minV = k;
                if((onboard[i] == 1 && t1 <= j & j <= t2) || onboard[i] == 0) {
                    if(0 <= j + flag && j + flag <= 50) {
                        minV = Math.min(minV, dp[i-1][j+flag]);
                    }
                    
                    if(j == temperature) {
                        minV = Math.min(minV, dp[i-1][j]);
                    }
                    
                    if(0 <= j-flag && j-flag <= 50) {
                        minV = Math.min(minV, dp[i-1][j-flag] + a);
                    }
                    
                    if(t1 <= j && j <= t2) {
                        minV = Math.min(minV, dp[i-1][j] + b);
                    }
                    
                    dp[i][j] = minV;
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int j = 0; j < 51; j++) {
            answer = Math.min(answer, dp[onboard.length - 1][j]);
        }
        
        return answer;
    }
}