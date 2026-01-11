class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        int max = 0;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int width = dp[i][j];
                if (width == 0) {
                    continue;
                }

                int curWidth = width;
                for (int k = i; k < n && dp[k][j] > 0; k++) {
                    curWidth = Math.min(curWidth, dp[k][j]);
                    int height = k - i + 1;
                    max = Math.max(max, curWidth * height);
                }

                curWidth = width;
                for (int k = i; k >= 0 && dp[k][j] > 0; k--) {
                    curWidth = Math.min(curWidth, dp[k][j]);
                    int height = i - k + 1;
                    max = Math.max(max, curWidth * height);
                }
            }
        }

        return max;
    }
}