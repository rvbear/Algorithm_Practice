import java.util.*;

class Solution {
    static Set<String> set;
    static boolean[] visit;
    public void dfs(String[] user_id, String[] banned_id, String res, int depth) {
        if(depth == banned_id.length) {
            String[] temp = res.split(" ");
            Arrays.sort(temp);           
            
            String result = "";
            for(String s : temp) {
                result += s;
            }
            
            set.add(result);
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(visit[i] || !user_id[i].matches(banned_id[depth])) {
                continue;
            }
            visit[i] = true;
            dfs(user_id, banned_id, res + " " + user_id[i], depth + 1);
            visit[i] = false;
        }
    }
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        visit = new boolean[user_id.length];
        
        for(int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }
        
        dfs(user_id, banned_id, "", 0);
        
        return set.size();
    }
}