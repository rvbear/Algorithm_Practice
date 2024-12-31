import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    char[][] map;
    boolean[][] visit;
    public int bfs(int x, int y) {
        int sum = 0;
        visit[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            sum += map[nx][ny] - '0';
            
            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                
                if(mx < 0 || my < 0 || mx >= map.length || my >= map[0].length) {
                    continue;
                }
                
                if(!visit[mx][my] && map[mx][my] != 'X') {
                    visit[mx][my] = true;
                    q.offer(new int[] {mx, my});
                }
            }
        }
        
        return sum;
    }
    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(!visit[i][j] && map[i][j] != 'X') {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        if(answer.size() == 0){
            answer.add(-1);
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}