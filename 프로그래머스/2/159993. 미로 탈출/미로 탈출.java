import java.util.*;

class Solution {
    char[][] map;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    public int bfs(int x, int y, char t) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        
        boolean[][] visit = new boolean[map.length][map[0].length];
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            int count = temp[2];
            
            visit[nx][ny] = true;
            
            if(map[nx][ny] == t) {
                return count;
            }
            
            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                
                if(mx >= 0 && my >= 0 && mx < map.length && my < map[0].length 
                   && !visit[mx][my] && map[mx][my] != 'X') {
                    visit[mx][my] = true;
                    q.add(new int[]{mx, my, count + 1});
                }
            }
        }
        
        return -1;
    }
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        int sx = 0, sy = 0, lx = 0, ly = 0;
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                
                if(map[i][j] == 'L') {
                    lx = i;
                    ly = j;
                } else if(map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        int result1 = bfs(sx, sy, 'L');
        int result2 = bfs(lx, ly, 'E');
        
        return (result1 == -1 || result2 == -1) ? -1 : result1 + result2;
    }
}