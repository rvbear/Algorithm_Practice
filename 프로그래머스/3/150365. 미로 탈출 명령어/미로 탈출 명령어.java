import java.util.*;
import java.lang.*;

class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] str = {"d", "l", "r", "u"};
    StringBuilder stb;
    int arrRow, arrCol;
    String answer = null;
    
    public int getDistance(int x, int y, int r, int c) {
        return Math.abs(x-r) + Math.abs(y-c);
    }
    
    public void dfs(int x, int y, int r, int c, int depth, int k) {
        if(answer != null || (depth + getDistance(x, y, r, c)) > k) {
            return;
        }
        if(k == depth) {
            answer = stb.toString();
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx <= arrRow && 0 < nx && ny <= arrCol && 0 < ny) {
                stb.append(str[i]);
                dfs(nx, ny, r, c, depth+1, k);
                stb.delete(depth, depth+1);
            }
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        stb = new StringBuilder();
        arrRow = n; arrCol = m;
        
        int distance = getDistance(x, y, r, c);
        if((k-distance) % 2 == 1 || k < distance) {
            return "impossible";
        }
        
        dfs(x, y, r, c, 0, k);
        
        return answer == null ? "impossible" : answer;
    }
}