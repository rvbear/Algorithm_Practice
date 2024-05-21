class Solution {
    int maxSheepCount = 0;
    public void dfs(int[] info, int[][] edges, int index, boolean[] visited, int sheepCount, int wolfCount) {
        visited[index] = true;
        
        if(info[index] == 0) {
            maxSheepCount = Math.max(++sheepCount, maxSheepCount);
        } else {
            wolfCount++;
        }
        
        if(sheepCount <= wolfCount) {
            return;
        }
        
        for(int[] edge : edges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisit = new boolean[visited.length];
                for(int i = 0; i < visited.length; i++) {
                    nextVisit[i] = visited[i];
                }
                
                dfs(info, edges, edge[1], nextVisit, sheepCount, wolfCount);
            }
        }
    }
    public int solution(int[] info, int[][] edges) {
        dfs(info, edges, 0, new boolean[info.length], 0, 0);
        
        return maxSheepCount;
    }
}