class Solution {
    int[] line;
    int answer;
    public boolean possible(int depth) {
        for(int i = 0; i < depth; i++) {
            if(line[i] == line[depth] || Math.abs(depth - i) == Math.abs(line[depth] - line[i])) {
                return false;
            }
        }
        return true;
    }
    public void dfs(int n, int depth) {
        if(n == depth) {
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            line[depth] = i;
            if(possible(depth)) {
                dfs(n, depth + 1);
            }
        }
    }
    public int solution(int n) {
        answer = 0;
        line = new int[n];
        
        dfs(n, 0);
        
        return answer;
    }
}