class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 2];
        dp[0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = Math.min(i, query_glass); j >= 0; j--) {
                if (dp[j] > 1) {
                    double val = (dp[j] - 1) / 2.0;
                    dp[j] = val;
                    dp[j + 1] += val;
                } else {
                    dp[j] = 0;
                }
            }
        }

        return Math.min(1, dp[query_glass]);
    }
}