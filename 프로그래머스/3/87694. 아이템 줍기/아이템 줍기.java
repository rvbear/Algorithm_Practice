import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map = new char[101][101];
    public static void draw(int x1, int y1, int x2, int y2) {
        for(int i = y1; i <= y2; i++) {
            for(int j = x1; j <= x2; j++) {
                if(map[i][j] == '1') {
                    continue;
                }
                map[i][j] = '1';
                if(i == y1 || i == y2 || j == x1 || j == x2) {
                    map[i][j] = '2';
                }
            }
        }
    }
    public int bfs(int x, int y, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        
        boolean[][] visit = new boolean[101][101];
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            int nx = temp[0];
            int ny = temp[1];
            int count = temp[2];
            
            if(nx == itemX && ny == itemY) {
                return count / 2;
            }
            
            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                
                if(mx < 0 || my < 0 || mx >= map[0].length || my >= map.length || visit[my][mx] || map[my][mx] != '2') {
                    continue;
                }
                
                visit[my][mx] = true;
                q.add(new int[]{mx, my, count + 1});
            }
        }
        
        return 0;
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            
            draw(x1*2, y1*2, x2*2, y2*2);
        }
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2);
    }
}