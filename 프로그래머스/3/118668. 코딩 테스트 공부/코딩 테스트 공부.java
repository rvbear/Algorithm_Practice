import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int goalAlp = 0, goalCop = 0;
        
        for(int[] problem : problems) {
            goalAlp = Math.max(goalAlp, problem[0]);
            goalCop = Math.max(goalCop, problem[1]);
        }
        
        if(goalAlp <= alp && goalCop <= cop) {
            return 0;
        }
        
        if(alp > goalAlp) {
            alp = goalAlp;
        }
        if(cop > goalCop) {
            cop = goalCop;
        }
        
        int[][] dp = new int[goalAlp+2][goalCop+2];
        for(int i = alp; i <= goalAlp; i++) {
            for(int j = cop; j <= goalCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= goalAlp; i++) {
            for(int j = cop; j <= goalCop; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] p : problems) {
                    if(i >= p[0] && j >= p[1]) {
                        if(i+p[2] > goalAlp && j+p[3] > goalCop) {
                            dp[goalAlp][goalCop] = Math.min(dp[goalAlp][goalCop], dp[i][j] + p[4]);
                        } else if(i+p[2] > goalAlp) {
                            dp[goalAlp][j+p[3]] = Math.min(dp[goalAlp][j+p[3]], dp[i][j] + p[4]);
                        } else if(j+p[3] > goalCop) {
                            dp[i+p[2]][goalCop] = Math.min(dp[i+p[2]][goalCop], dp[i][j] + p[4]);
                        } else if(i+p[2] <= goalAlp && j+p[3] <= goalCop) {
                            dp[i+p[2]][j+p[3]] = Math.min(dp[i+p[2]][j+p[3]], dp[i][j] + p[4]);
                        }
                    }
                }
            }
        }
        
        return dp[goalAlp][goalCop];
    }
}