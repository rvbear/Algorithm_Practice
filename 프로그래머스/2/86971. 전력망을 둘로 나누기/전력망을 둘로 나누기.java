import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int answer;
    public int dfs(int v, boolean[] visit) {
        visit[v] = true;
        int count = 1;
        
        for(int next : graph[v]) {
            if(!visit[next]) {
                count += dfs(next, visit);
            }
        }
        
        return count;
    }
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        answer = Integer.MAX_VALUE;
        
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            boolean[] visit = new boolean[n+1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int count = dfs(1, visit);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
}