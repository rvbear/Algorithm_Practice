import java.util.*;

class Solution {
    public boolean bfs(int x, int y, String[] p) {
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ x, y });
        
        while(!q.isEmpty()) {
            int nx = q.peek()[0];
            int ny = q.peek()[1];
            q.poll();
            
            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                
                if(mx < 0 || my < 0 || mx >= 5 || my >= 5 || (mx == x && my == y)) {
                    continue;
                }
                
                int d = Math.abs(mx - x) + Math.abs(my - y);
                
                if(p[mx].charAt(my) == 'P' && d <= 2) {
                    return false;
                } else if(p[mx].charAt(my) == 'O' && d < 2) {
                    q.offer(new int[]{ mx, my });
                }
            }
        }
        
        return true;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < answer.length; i++) {
            String[] p = places[i];
            
            boolean flag = true;
            for(int x = 0; x < 5 && flag; x++) {
                for(int y = 0; y < 5 && flag; y++) {
                    if(p[x].charAt(y) == 'P') {
                        if(!bfs(x, y, p)) {
                            flag = false;
                        }
                    }
                }
            }
            
            answer[i] = flag ? 1 : 0;
        }
        
        return answer;
    }
}