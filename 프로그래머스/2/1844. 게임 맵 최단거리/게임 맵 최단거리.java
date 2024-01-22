import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public void bfs(int[][] maps, int[][] visited) {
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.remove();
            int x = temp[0];
            int y = temp[1];
            
            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                
                if(mx < 0 || mx > maps.length - 1 || my < 0 || my > maps[0].length - 1) {
                    continue;
                }
                
                if(visited[mx][my] == 0 && maps[mx][my] == 1) {
                    visited[mx][my] = visited[x][y] + 1;
                    queue.add(new int[] {mx, my});
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        return answer == 0 ? -1 : answer;
    }
}