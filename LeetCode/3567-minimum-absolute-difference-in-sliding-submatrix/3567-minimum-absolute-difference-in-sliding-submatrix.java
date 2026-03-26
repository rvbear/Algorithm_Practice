class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n - k + 1][m - k + 1];

        for (int i = k - 1; i < n; i++) {
            for (int j = k - 1; j < m; j++) {
                int[] temp = new int[k * k];

                for (int ii = i - k + 1; ii <= i; ii++) {
                    for (int jj = j - k + 1; jj <= j; jj++) {
                        temp[(ii - (i - k + 1)) * k + (jj - (j - k + 1))] = grid[ii][jj];
                    }
                }

                Arrays.sort(temp);
                ans[i - (k - 1)][j - (k - 1)] = temp[temp.length - 1] - temp[0];

                for (int kk = 1; kk < temp.length; kk++) {
                    if (temp[kk] == temp[kk-1]) {
                        continue;
                    }

                    ans[i - (k - 1)][j - (k - 1)] = Math.min(ans[i - (k - 1)][j - (k - 1)], temp[kk] - temp[kk - 1]);
                }
            }
        }

        return ans;
    }
}