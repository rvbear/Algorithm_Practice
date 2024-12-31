import java.util.*;

class Solution {
    int[] cost;
    List<Integer>[] graph;
    public void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        cost[start] = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if(cost[next] == -1) {
                    cost[next] = cost[now] + 1;
                    q.add(next);
                }
            }
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new List[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] data : roads) {
            graph[data[0]].add(data[1]);
            graph[data[1]].add(data[0]);
        }
        
        cost = new int[n+1];
        Arrays.fill(cost, -1);
        dijkstra(destination);
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            answer[i] = cost[sources[i]];
        }
        return answer;
    }
}