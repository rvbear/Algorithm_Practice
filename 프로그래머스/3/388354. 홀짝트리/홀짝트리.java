import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map;
    Map<Integer, Boolean> visit;
    
    void bfs(int[] ans, int node) {
        visit.put(node, true);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        int cnt = 0;
        int reverseCnt = 0;
        
        while (!q.isEmpty()) {
            int p = q.poll();
            int edgeNum = map.get(p).size();
            
            if (p % 2 == edgeNum % 2) {
                cnt++;
            } else {
                reverseCnt++;
            }
            
            for (int adj : map.get(p)) {
                if (visit.get(adj)) {
                    continue;
                }
                
                visit.put(adj, true);
                q.add(adj);
            }
        }
        
        if (cnt == 1) {
            ans[0]++;
        }
        
        if (reverseCnt == 1) {
            ans[1]++;
        }
    }
    
    public int[] solution(int[] nodes, int[][] edges) {
        map = new HashMap<>();
        visit = new HashMap<>();
        
        for (int node : nodes) {
            map.put(node, new ArrayList<>());
            visit.put(node, false);
        }
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        int[] answer = new int[2];
        for (int node : nodes) {
            if (visit.get(node)) {
                continue;
            }
            
            bfs(answer, node);
        }
        
        return answer;
    }
}