import java.util.*;

class Solution {
    int numberOfArea;
    int maxSizeOfOneArea;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visit;
    public int bfs(int x, int y, int[][] map, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        int count = 1;
        
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            
            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                
                if(mx < 0 || my < 0 || mx >= m || my >= n) {
                    continue;
                }
                
                if(!visit[mx][my] && map[nx][ny] == map[mx][my]) {
                    visit[mx][my] = true;
                    count++;
                    q.add(new int[]{mx, my});
                }
            }
        }
        
        return count;
    }
    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visit[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture, m, n));
                }
            }
        }
        
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}