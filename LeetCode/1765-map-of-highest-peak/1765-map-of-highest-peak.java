class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] matrix = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    q.add(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];

            for(int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1) {
                    matrix[nr][nc] = matrix[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return matrix;
    }
}