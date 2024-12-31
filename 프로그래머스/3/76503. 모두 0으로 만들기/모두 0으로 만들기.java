import java.util.*;

class Solution {
    public long[] atmp;
    public int[] indegree;
    public ArrayList<Integer>[] map;
    public int n, root = 0;
    public long answer = 0;
    public long solution(int[] a, int[][] edges) {
        n = a.length;
        atmp = new long[n];
        
        for(int i = 0; i < n; i++) {
            atmp[i] = a[i];
            answer += atmp[i];
        }
        
        if(answer != 0) {
            return -1;
        }
        if(n == 2) {
            return Math.abs(a[0]);
        }
        
        map = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        
        indegree = new int[n];
        for(int i = 0; i < edges.length; i++) {
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n; i++) {
            if(map[i].size() == 1) {
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            
            answer += Math.abs(atmp[tmp]);
            indegree[tmp]--;
            
            for(int i = 0; i < map[tmp].size(); i++) {
                int next = map[tmp].get(i);
                
                if(indegree[next] == 0) {
                    continue;
                }
                
                indegree[next]--;
                atmp[next] += atmp[tmp];
                
                if(indegree[next] == 1) {
                    if(next == root) {
                        continue;
                    }
                    queue.add(next);
                }
            }
        }
        
        return answer;
    }
}