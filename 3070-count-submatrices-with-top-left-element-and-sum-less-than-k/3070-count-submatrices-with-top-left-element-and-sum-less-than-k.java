class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length, ans = 0;
        int[][] temp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i + 1][j + 1] = grid[i][j] + temp[i][j + 1] + temp[i + 1][j] - temp[i][j];

                if (temp[i + 1][j + 1] <= k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}