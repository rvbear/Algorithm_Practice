class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        int x = 5, y = 5, d = 0, answer = 0;
        boolean[][][] visit = new boolean[11][11][4];
        
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if(c == 'U') {
                d = 0;
            } else if(c == 'D') {
                d = 1;
            } else if(c == 'R') {
                d = 2;
            } else if(c == 'L') {
                d = 3;
            }
            
            int mx = x + dx[d];
            int my = y + dy[d];
            
            if(mx < 0 || my < 0 || mx >= 11 || my >= 11) {
                continue;
            }
            
            if(!visit[mx][my][d]) {
                visit[mx][my][d] = true;
                d += (d == 0 || d == 2) ? 1 : -1;
                visit[x][y][d] = true;
                answer++;
            }
            
            x = mx;
            y = my;
        }
        
        return answer;
    }
}