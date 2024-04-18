import java.util.*;

class Solution {
    int X, Y;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    boolean[][][] visit;
    public int light(String[] grid, int x, int y, int z) {
        int count = 0;
        
        while(true) {
            if(visit[x][y][z]) {
                break;
            }
            
            count++;
            visit[x][y][z] = true;
            
            if(grid[x].charAt(y) == 'L') {
                z = z == 0 ? 3 : z - 1;
            } else if(grid[x].charAt(y) == 'R') {
                z = z == 3 ? 0 : z + 1;
            }
            
            x = (x + dx[z] + X) % X;
            y = (y + dy[z] + Y) % Y;
        }
        
        return count;
    }
    public int[] solution(String[] grid) {
        X = grid.length;
        Y = grid[0].length();
        ArrayList<Integer> answer = new ArrayList<>();
        visit = new boolean[X][Y][4];
        
        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++) {
                for(int k = 0; k < 4; k++) {
                    if(!visit[i][j][k]) {
                        answer.add(light(grid, i, j, k));
                    }
                }
            }
        }
        
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
}