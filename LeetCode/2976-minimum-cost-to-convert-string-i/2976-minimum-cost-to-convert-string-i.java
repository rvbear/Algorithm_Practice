class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dp = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < original.length; i++) {
            dp[original[i] - 'a'][changed[i] - 'a'] = Math.min(dp[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (i == k) {
                    continue;
                }

                if (dp[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (k == j) {
                            continue;
                        }

                        if (dp[k][j] < Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                        }
                    }
                }
            }
        }

        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';

            if (c1 == c2) {
                continue;
            }

            if (dp[c1][c2] == Integer.MAX_VALUE) {
                return -1L;
            }

            ans += (long) dp[c1][c2];
        }

        return ans;
    }
}