class Solution {
    int max = 0;
    int[] res = new int[11];
    int[] answer = { 0 };
    public void dfs(int[] info, int n, int depth) {
        if(depth == n) {
            int apeach = 0, lion = 0;
            
            for(int i = 0; i <= n; i++) {
                if(info[i] == 0 && res[i] == 0) {
                    continue;
                }
                if(info[i] >= res[i]) {
                    apeach += (10 - i);
                } else {
                    lion += (10 - i);
                }
            }
            
            if((lion - apeach) >= max) {
                answer = res.clone();
                max = lion - apeach;
            }
            
            return;
        }
        
        for(int i = 0; i < info.length && res[i] <= info[i]; i++) {
            res[i] += 1;
            dfs(info, n, depth + 1);
            res[i] -= 1;
        }
    }
    public int[] solution(int n, int[] info) {
        dfs(info, n, 0);
        
        return max == 0 ? new int[] { -1 } : answer;
    }
}