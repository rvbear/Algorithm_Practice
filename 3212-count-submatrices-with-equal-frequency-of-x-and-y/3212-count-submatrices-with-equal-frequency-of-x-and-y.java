class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] diff = new int[n + 1][m + 1];
        boolean[][] hasX = new boolean[n + 1][m + 1];
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int val = 0;

                if (grid[i - 1][j - 1] == 'X') {
                    val = 1;
                } else if (grid[i - 1][j - 1] == 'Y') {
                    val = -1;
                }

                diff[i][j] = diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1] + val;
                hasX[i][j] = hasX[i - 1][j] || hasX[i][j - 1] || hasX[i - 1][j - 1] || (grid[i - 1][j - 1] == 'X');

                if (hasX[i][j] && diff[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}