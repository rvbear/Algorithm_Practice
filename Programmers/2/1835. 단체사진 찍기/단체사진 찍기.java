class Solution {
    char[] friends;
    int answer;
    boolean[] visited;
    public boolean check(String line, String[] data) {
        for(String cond : data) {
            int diff = Math.abs(line.indexOf(cond.charAt(0)) - line.indexOf(cond.charAt(2))) - 1;
            char sign = cond.charAt(3);
            int value = cond.charAt(4) - '0';
            
            if(sign == '=') {
                if(diff != value) {
                    return false;
                }
            } else if(sign == '>') {
                if(diff <= value) {
                    return false;
                }
            } else if(sign == '<') {
                if(diff >= value) {
                    return false;
                }
            }
        }
        
        return true;
    }
    public void dfs(String line, String[] data, int depth) {
        if(depth == 8) {
            if(check(line, data)) {
                answer++;
            }
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(line + friends[i], data, depth + 1);
                visited[i] = false;
            }
        }
    }
    public int solution(int n, String[] data) {
        answer = 0;
        friends = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];
        
        dfs("", data, 0);
        
        return answer;
    }
}