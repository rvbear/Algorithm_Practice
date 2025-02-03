import java.util.*;

class Solution {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    
    private int[] calNextRange(int s, int e, int move, int max) {
        int nextS = (s == 0 && move > 0) ? 0 : s + move;
        int nextE = (e == max - 1 && move < 0) ? max - 1 : e + move;
        
        if ((nextS < 0 || nextS >= max) && (nextE < 0 || nextE >= max)) {
            return new int[] {-1, -1};
        }
        
        if (nextS < 0 && nextE >= 0 && nextE < max) {
            return new int[] {0, nextE};
        }
        
        if (nextE >= max && nextS >= 0 && nextS < max) {
            return new int[] {nextS, max - 1};
        }
        
        return new int[] {nextS, nextE};
    }
    
    public long solution(int n, int m, int x, int y, int[][] queries) {
        int sx, sy, ex, ey;
        sx = ex = x;
        sy = ey = y;
        
        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            int cnt = queries[i][1];
            
            if (dir == 0 || dir == 1) {
                int[] res = calNextRange(sy, ey, cnt * dy[dir], m);
                if (res[0] == -1) {
                    return 0;
                }
                
                sy = res[0];
                ey = res[1];
            }
            
            if (dir == 2 || dir == 3) {
                int[] res = calNextRange(sx, ex, cnt * dx[dir], n);
                if (res[0] == -1) {
                    return 0;
                }
                
                sx = res[0];
                ex = res[1];
            }
        }
        
        return (long)(ex - sx + 1) * (long)(ey - sy + 1);
    }
}