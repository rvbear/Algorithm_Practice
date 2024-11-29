class Solution {
    public int minimumTime(int[][] grid) {
        if(Math.min(grid[0][1], grid[1][0]) > 1) {
            return -1;
        }
        
        int rows = grid.length, cols = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        Set<String> visit = new HashSet<>();
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            
            if(r == rows - 1 && c == cols - 1) {
                return t;
            }
            
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                String key = nr + "," + nc;
                
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols || visit.contains(key)) {
                    continue;
                }
                
                int wait = (Math.abs(grid[nr][nc] - t) % 2 == 0) ? 1 : 0;
                int nTime = Math.max(grid[nr][nc] + wait, t + 1);
                pq.offer(new int[]{nTime, nr, nc});
                visit.add(key);
            }
        }

        return -1;
    }
}