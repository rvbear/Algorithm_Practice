import java.util.*;

class Solution {
    ArrayList<Integer>[] node;
    int[] visit;
    int depth = 0;
    public void bfs(int start, int count) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, count});
        visit[start] = count;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            if(depth < temp[1]) {
                depth = temp[1];
            }
            
            for(int i = 0; i < node[temp[0]].size(); i++) {
                int next = node[temp[0]].get(i);
                
                if(visit[next] != 0) {
                    continue;
                }
                
                visit[next] = temp[1] + 1;
                q.add(new int[]{next, visit[next]});
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new int[n+1];
        node = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            node[edge[i][0]].add(edge[i][1]);
            node[edge[i][1]].add(edge[i][0]);
        }
        
        bfs(1, 1);
        
        for(int i = 1; i <= n; i++) {
            if(depth == visit[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}