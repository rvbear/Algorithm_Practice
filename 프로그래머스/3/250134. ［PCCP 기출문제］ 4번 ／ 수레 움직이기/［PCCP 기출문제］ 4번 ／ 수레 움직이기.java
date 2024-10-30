class Solution {
    int n, m, answer = Integer.MAX_VALUE;
    int rx, ry, bx, by;
    int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
    int[][] map, red, blue;
    
    public void dfs(int x1, int y1, int x2, int y2, int depth) {
        if(map[x1][y1] == 3 && map[x2][y2] == 4) {
            answer = Math.min(answer, depth);
            return;
        } else if(map[x1][y1] == 3) {
            for(int i = 0; i < 4; i++) {
                int bx = x2 + dx[i];
                int by = y2 + dy[i];
                
                if(bx < 0 || by < 0 || bx >= n || by >= m) continue;
                if(blue[bx][by] == 1) continue;
                if(map[bx][by] == 3 || map[bx][by] == 5) continue;
                
                blue[bx][by] = 1;
                dfs(x1, y1, bx, by, depth + 1);
                blue[bx][by] = 0;
            }
        } else if(map[x2][y2] == 4) {
            for(int i = 0; i < 4; i++) {
                int rx = x1 + dx[i];
                int ry = y1 + dy[i];
                
                if(rx < 0 || ry < 0 || rx >= n || ry >= m) continue;
                if(red[rx][ry] == 1) continue;
                if(map[rx][ry] == 4 || map[rx][ry] == 5) continue;
                
                red[rx][ry] = 1;
                dfs(rx, ry, x2, y2, depth + 1);
                red[rx][ry] = 0;
            }
        } else {
            for(int i = 0; i < 4; i++) {
                int rx = x1 + dx[i];
                int ry = y1 + dy[i];
                
                if(rx < 0 || ry < 0 || rx >= n || ry >= m) continue;
                if(red[rx][ry] == 1 || map[rx][ry] == 5) continue;
                
                for(int j = 0; j < 4; j++) {
                    int bx = x2 + dx[j];
                    int by = y2 + dy[j];
                    
                    if(bx < 0 || by < 0 || bx >= n || by >= m) continue;
                    if(blue[bx][by] == 1 || map[bx][by] == 5) continue;
                    if(rx == bx && ry == by) continue;
                    if((rx == x2 && ry == y2) && (bx == x1 && by == y1)) continue;
                    
                    red[rx][ry] = 1;
                    blue[bx][by] = 1;
                    dfs(rx, ry, bx, by, depth + 1);
                    red[rx][ry] = 0;
                    blue[bx][by] = 0;
                }
            }
        }
    }
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        map = new int[n][m];
        red = new int[n][m];
        blue = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = maze[i][j];
                if(map[i][j] == 1) {
                    red[i][j] = 1;
                    rx = i; ry = j;
                } else if(map[i][j] == 2) {
                    blue[i][j] = 1;
                    bx = i; by = j;
                }
            }
        }
        
        dfs(rx, ry, bx, by, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}