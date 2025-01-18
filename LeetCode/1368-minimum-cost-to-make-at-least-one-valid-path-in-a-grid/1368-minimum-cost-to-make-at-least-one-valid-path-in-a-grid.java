class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});
        dist[0][0] = 0;
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

        while(!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];
            int curDir = grid[x][y] - 1;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx > n-1 || ny > m-1) {
                    continue;
                }

                int cost = dist[x][y] + (i == curDir ? 0 : 1);
                if(cost < dist[nx][ny]) {
                    dist[nx][ny] = cost;
                    if(i == curDir) {
                        dq.offerFirst(new int[]{nx, ny});
                    } else {
                        dq.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return dist[n-1][m-1];
    }
}