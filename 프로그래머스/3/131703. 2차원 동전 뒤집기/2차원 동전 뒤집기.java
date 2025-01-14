import java.util.*;

class Solution {
    int n, m, ans;
    int[][] board, t;
    
    private void filpRow(int r) {
        for(int i = 0; i < m; i++) {
            board[r][i] = (board[r][i] + 1) % 2;
        }
    }
    
    private int compareCol(int c) {
        int check = 0;
        
        for(int i = 0; i < n; i++) {
            if(board[i][c] == t[i][c]) {
                check++;
            }
        }
        
        return check == n ? 0 : (check == 0 ? 1 : -1);
    }
    
    private void dfs(int r, int cnt) {
        if(r == n) {
            for(int i = 0; i < m; i++) {
                int res = compareCol(i);
                if(res == -1) {
                    return;
                }
                
                cnt += res;
            }
            
            ans = Math.min(cnt, ans);
            return;
        }
        
        filpRow(r);
        dfs(r+1, cnt+1);
        filpRow(r);
        dfs(r+1, cnt);
    }
    
    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        ans = Integer.MAX_VALUE;
        t = target;
        board = new int[n][m];
        for(int i = 0; i < n; i++) {
            board[i] = beginning[i].clone();
        }
        
        dfs(0, 0);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}