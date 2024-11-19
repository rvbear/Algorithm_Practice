class Solution {
    static boolean[] visit;
    public void dfs(int[][] computers, int i) {
        visit[i] = true;
        
        for(int j = 0; j < computers.length; j++) {
            if(i != j && computers[i][j] == 1 && !visit[j]) {
                dfs(computers, j);
            }
        }
        
        return;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
}