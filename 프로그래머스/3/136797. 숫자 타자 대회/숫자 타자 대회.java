import java.util.*;

class Solution {
    int[][] cost = {
        {1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
        {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
        {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
        {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
        {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
        {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
        {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
        {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
        {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
        {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
    };
    int[][][] dp;
    String arr;
    int n;
    
    public int solve(int idx, int left, int right) {
        if(idx == n) {
            return 0;
        }
        
        if(dp[idx][left][right] != -1) {
            return dp[idx][left][right];
        }
        
        int num = arr.charAt(idx) - '0';
        int res = Integer.MAX_VALUE;
        
        if(num != right) {
            res = Math.min(solve(idx+1, num, right) + cost[left][num], res);
        }
        if(num != left) {
            res = Math.min(solve(idx+1, left, num) + cost[num][right], res);
        }
        
        return dp[idx][left][right] = res;
    }
    
    public int solution(String numbers) {
        arr = numbers;
        n = numbers.length();
        dp = new int[n+1][10][10];
        
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return solve(0, 4, 6);
    }
}