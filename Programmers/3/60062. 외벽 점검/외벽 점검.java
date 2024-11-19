class Solution {
    int answer;
    int[] weakAppend;
    public int check(int start, int end, int[] change) {
        int friend = 1;
        int pos = weakAppend[start] + change[friend - 1];
        
        for(int i = start; i < end; i++) {
            if(pos < weakAppend[i]) {
                friend++;
                
                if(friend > change.length) {
                    return Integer.MAX_VALUE;
                }
                
                pos = weakAppend[i] + change[friend - 1];
            }
        }
        
        return friend;
    }
    public void dfs(int start, int[] dist, boolean[] visit, int[] change, int depth) {
        if(depth == dist.length) {
            answer = Math.min(answer, check(start, start + weakAppend.length / 2, change));
            return;
        }
        
        for(int i = 0; i < dist.length; i++) {
            if(visit[i]) {
                continue;
            }
            
            visit[i] = true;
            change[depth] = dist[i];
            dfs(start, dist, visit, change, depth + 1);
            visit[i] = false;
        }
    }
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        weakAppend = new int[weak.length * 2];
        
        for(int i = 0; i < weak.length; i++) {
            weakAppend[i] = weak[i];
            weakAppend[i + weak.length] = weak[i] + n;
        }
        
        for(int i = 0; i < weak.length; i++) {
            dfs(i, dist, new boolean[dist.length], new int[dist.length], 0);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}