import java.util.*;

class Solution {
    public int solution(int[][] matrixsizes) {
        int n = matrixsizes.length;
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-i; j++) {
                int a = j;
                int b = j+i;
                
                if(a == b) {
                    dp[a][b] = 0; 
                } else {
                    for(int k = a; k < b; k++) {
                        dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k+1][b] + matrixsizes[a][0] * matrixsizes[k][1] * matrixsizes[b][1]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}