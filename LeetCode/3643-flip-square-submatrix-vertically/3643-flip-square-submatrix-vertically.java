class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = x, ii = x + k - 1; i < ii; i++, ii--) {
            for (int j = y; j < y + k; j++) {
                int val = grid[i][j];
                grid[i][j] = grid[ii][j];
                grid[ii][j] = val;
            }
        }

        return grid;
    }
}