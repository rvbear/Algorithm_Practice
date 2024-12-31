import java.util.*;

class Solution {
    int answer;
    char[][] map;
    
    class Point {
        int x, y;
        
        Point(int _x, int _y) {
            x = _x; y = _y;
        }
    }
    
    public boolean remove() {
        Set<Point> set = new HashSet<>();
        
        for(int i = 0; i < map.length - 1; i++) {
            for(int j = 0; j < map[0].length - 1; j++) {
                if(map[i][j] == ' ') {
                    continue;
                }
                if(map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]) {
                    set.add(new Point(i, j));
                    set.add(new Point(i, j+1));
                    set.add(new Point(i+1, j));
                    set.add(new Point(i+1, j+1));
                }
            }
        }
        
        Iterator<Point> iter = set.iterator();
        while(iter.hasNext()) {
            Point p = iter.next();
            
            if(map[p.x][p.y] == ' ') {
                continue;
            }
            map[p.x][p.y] = ' ';
            answer++;
        }
        
        return set.size() == 0 ? false : true;
    }
    
    public void blockdown() {
        for(int j = 0; j < map[0].length; j++) {
            int space = 0;
            for(int i = map.length - 1; i >= 0; i--) {
                if(map[i][j] == ' ') {
                    space++;
                } else if(map[i][j] != ' ' && space != 0) {
                    map[i+space][j] = map[i][j];
                    map[i][j] = ' ';
                }
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        answer = 0;
        map = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(remove()) {
            blockdown();
        }
        
        return answer;
    }
}