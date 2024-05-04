import java.util.*;

class Solution {
    int n;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][][] visit;
    class Node {
        int x, y, dir, cost;
        
        public Node(int _x, int _y, int _dir, int _cost) {
            x = _x; y = _y; dir = _dir; cost = _cost;
        }
    }
    public int bfs(int[][] board) {
        int x = 0, y = 0, dir = -1, cost = 0;
        int minCost = Integer.MAX_VALUE;
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, dir, cost));
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            if(now.x == n-1 && now.y == n-1) {
                minCost = Math.min(minCost, now.cost);
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                
                int nextCost = now.cost;
                if(now.dir == -1 || now.dir == i) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }
                
                if(!visit[nx][ny][i] || board[nx][ny] >= nextCost) {
                    q.add(new Node(nx, ny, i, nextCost));
                    visit[nx][ny][i] = true;
                    board[nx][ny] = nextCost;
                }
            }
        }
        return minCost;
    }
    public int solution(int[][] board) {
        n = board.length;
        visit = new boolean[n][n][4];
        
        return bfs(board);
    }
}