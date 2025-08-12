class Solution {
    static final int MOD = 1_000_000_007;
    
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int temp = (int) Math.pow(i, x);
            for (int s = n; s >= temp; s--) {
                dp[s] = (dp[s] + dp[s - temp]) % MOD;
            }
        }

        return (int) dp[n];
    }
}
