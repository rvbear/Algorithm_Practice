import java.util.*;

class Solution {
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static int[][] hRotate = {{-1, 0}, {0, 0}, {-1, 1}, {0, 1}};
    static int[][] hCheck = {{-1, 1}, {1, 1}, {-1, 0}, {1, 0}};
    
    static int[][] vRotate = {{0, -1}, {1, -1}, {0, 0}, {1, 0}};
    static int[][] vCheck = {{1, -1}, {0, -1}, {1, 1}, {0, 1}};

    static int[][] newBoard;
    static int answer = 0;
    static boolean[][][] visit;
    static int n;
    
    static class Robot {
        int x, y, dir, sec;
        
        Robot(int x, int y, int dir, int sec) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sec = sec;
        }
    }
    
    static boolean check(int x, int y, int dir) {
        if(x < 0 || x >= n || y < 0 || y >= n || visit[x][y][dir] || newBoard[x][y] == 1) {
            return false;
        }
        
        if(dir == 0 && (y + 1 >= n || newBoard[x][y+1] == 1)) {
            return false;
        }
        
        if(dir == 1 && (x + 1 >= n || newBoard[x+1][y] == 1)) {
            return false;
        }
        
        return true;
    }
    static void bfs() {
        Queue<Robot> q = new LinkedList<>();
        
        q.offer(new Robot(0, 0, 0, 0));
        visit[0][0][0] = true;
        
        while(!q.isEmpty()) {
            Robot now = q.poll();
            
            if((now.dir == 0 && now.x == n - 1 && now.y + 1 == n -1) || (now.dir == 1 && now.x + 1 == n -1 && now.y == n -1)) {
                answer = now.sec;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + move[i][0];
                int ny = now.y + move[i][1];
                
                if(check(nx, ny, now.dir)) {
                    visit[nx][ny][now.dir] = true;
                    q.offer(new Robot(nx, ny, now.dir, now.sec + 1));
                }
            }
            
            if(now.dir == 0) {
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + hRotate[i][0];
                    int ny = now.y + hRotate[i][1];
                    int ndir = 1;
                    
                    if(check(nx, ny, ndir) && newBoard[now.x + hCheck[i][0]][now.y + hCheck[i][1]] == 0) {
                        visit[nx][ny][ndir] = true;
                        q.offer(new Robot(nx, ny, ndir, now.sec + 1));
                    }
                }
            } else {
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + vRotate[i][0];
                    int ny = now.y + vRotate[i][1];
                    int ndir = 0;
                    
                    if(check(nx, ny, ndir) && newBoard[now.x + vCheck[i][0]][now.y + vCheck[i][1]] == 0) {
                        visit[nx][ny][ndir] = true;
                        q.offer(new Robot(nx, ny, ndir, now.sec + 1));
                    }
                }
            }
        }
    }
    public int solution(int[][] board) {
        newBoard = board;
        n = board.length;
        
        visit = new boolean[n][n][2];
        
        bfs();
        
        return answer;
    }
}