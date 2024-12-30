class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        
        if(zero > one) {
            return countGoodStrings(low, high, one, zero);
        }

        int[] dp = new int[high+1];
        int res = 0;
        dp[0] = 1;

        for(int i = 1; i <= high; i++) {
            if(i >= zero) {
                dp[i] = (dp[i] + dp[i-zero]) % mod;
            }

            if(i >= one) {
                dp[i] = (dp[i] + dp[i-one]) % mod;
            }

            if(i >= low) {
                res = (res + dp[i]) % mod;
            }
        }

        return res;
    }
}