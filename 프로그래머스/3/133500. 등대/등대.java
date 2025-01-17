import java.util.*;

class Solution {
    int res;
    List<List<Integer>> map;
    int dfs(int cur, int before) {
        if(map.get(cur).size() == 1 && map.get(cur).get(0) == before) {
            return 1;
        }
        
        int temp = 0;
        for(int i = 0; i < map.get(cur).size(); i++) {
            int next = map.get(cur).get(i);
            
            if(next == before) {
                continue;
            }
            temp += dfs(next, cur);
        }
        
        if(temp == 0) {
            return 1;
        }
        
        res++;
        return 0;
    }
    public int solution(int n, int[][] lighthouse) {
        res = 0;
        map = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        
        for(int i = 0; i < lighthouse.length; i++) {
            map.get(lighthouse[i][0]).add(lighthouse[i][1]);
            map.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        
        dfs(1, 0);
        
        return res;
    }
}