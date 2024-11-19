import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        Queue<int[]>[] record = new LinkedList[routes.length];
        int answer = 0;
        int size = routes.length;
        
        for(int i = 0; i < size; i++) {
            record[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < size; i++) {
            int[] point = points[routes[i][0] - 1];
            int x = point[0], y = point[1];
            
            record[i].add(new int[] {x, y});
            
            for(int j = 1; j < routes[0].length; j++) {
                int[] nextPoint = points[routes[i][j] - 1];
                int nx = nextPoint[0], ny = nextPoint[1];
                int xp = nx - x, yp = ny - y;
                
                while(xp != 0) {
                    if(xp > 0) {
                        xp--;
                        x++;
                    } else {
                        xp++;
                        x--;
                    }
                    record[i].add(new int[] {x, y});
                }
                
                while(yp != 0) {
                    if(yp > 0) {
                        yp--;
                        y++;
                    } else {
                        yp++;
                        y--;
                    }
                    record[i].add(new int[] {x, y});
                }
            }
        }
        
        int count = 0;
        while(count != size) {
            int[][] map = new int[101][101];
            count = 0;
            
            for(int i = 0; i < size; i++) {
                if(record[i].isEmpty()) {
                    count++;
                    continue;
                }
                int[] temp = record[i].poll();
                map[temp[0]][temp[1]]++;
            }
            
            for(int i = 0; i < 101; i++) {
                for(int j = 0; j < 101; j++) {
                    if(map[i][j] > 1) answer++;
                }
            }
        }
        
        return answer;
    }
}