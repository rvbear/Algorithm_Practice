import java.util.*;

class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    char[][] map;
    int n, m;
    public int bfs(int rx, int ry, int gx, int gy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{rx, ry, 0});
        
        boolean[][] visit = new boolean[n][m];
        visit[rx][ry] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            int move = now[2];
            
            if(nx == gx && ny == gy) {
                return move;
            }
            
            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                while(mx >= 0 && my >= 0 && mx < n && my < m && map[mx][my] != 'D') {
                    mx += dx[i];
                    my += dy[i];
                }
                
                mx -= dx[i];
                my -= dy[i];
                
                if(visit[mx][my] || (mx == nx && my == ny)) {
                    continue;
                }
                
                visit[mx][my] = true;
                q.offer(new int[]{ mx, my, move+1 });
            }
        }
        
        return -1;
    }
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        int rx = 0, ry = 0, gx = 0, gy = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if(map[i][j] == 'G') {
                    gx = i;
                    gy = j;
                }
            }
        }
        
        return bfs(rx, ry, gx, gy);
    }
}