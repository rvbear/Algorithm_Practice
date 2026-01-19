class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] sum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = mat[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int len = max + 1;

                if (i >= len && j >= len) {
                    int r1 = i - len + 1;
                    int c1 = j - len + 1;
                    int total = sum[i][j] - sum[r1 - 1][j] - sum[i][c1 - 1] + sum[r1 - 1][c1 - 1];

                    if (total <= threshold) {
                        max++;
                    }
                }
            }
        }

        return max;
    }
}