import java.util.*;

class Solution {
    static int n, m;
    static int[] oil;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    public void bfs(int[][] land, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            
            set.add(ny);
            
            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                
                if(mx < 0 || my < 0 || mx >= n || my >= m) {
                    continue;
                }
                
                if(land[mx][my] == 1 && !visit[mx][my]) {
                    q.add(new int[]{mx, my});
                    visit[mx][my] = true;
                    count++;
                }
            }
        }
        
        for(int index : set) {
            oil[index] += count;
        }
    }
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        visit = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visit[i][j]) {
                    bfs(land, i, j);
                }
            }
        }
        
        return Arrays.stream(oil).max().getAsInt();
    }
}