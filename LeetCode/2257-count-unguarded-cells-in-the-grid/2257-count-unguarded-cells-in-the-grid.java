class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];

        for(int[] g : guards) {
            arr[g[0]][g[1]] = 2;
        }

        for(int[] w : walls) {
            arr[w[0]][w[1]] = 2;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int[] g : guards) {
            for(int i = 0; i < 4; i++) {
                int x = g[0], y = g[1];

                while(x + dx[i] >= 0 && x + dx[i] < m && y + dy[i] >= 0 && y + dy[i] < n && arr[x + dx[i]][y + dy[i]] < 2) {
                    x += dx[i];
                    y += dy[i];
                    arr[x][y] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}