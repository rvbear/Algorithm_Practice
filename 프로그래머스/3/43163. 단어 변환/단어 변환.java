class Solution {
    static boolean[] visit;
    static int answer;
    public void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = Math.min(count, answer);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(visit[i]) {
                continue;
            }
            
            int k = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }
            
            if(k == begin.length() - 1) {
                visit[i] = true;
                dfs(words[i], target, words, count + 1);
                visit[i] = false;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visit = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}