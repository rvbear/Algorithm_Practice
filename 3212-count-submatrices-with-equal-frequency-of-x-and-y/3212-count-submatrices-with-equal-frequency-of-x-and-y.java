class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] colX = new int[m];
        int[] colY = new int[m];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 'X') {
                    colX[j]++;
                }

                if(grid[i][j] == 'Y') {
                    colY[j]++;
                }
            }
            
            int x = 0, y = 0;

            for(int j = 0; j < m; j++) {
                x += colX[j];
                y += colY[j];

                if(x == y && x > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}