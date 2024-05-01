import java.util.*;

class Solution {
    boolean[] visit;
    ArrayList<String> allRoute;
    public void dfs(String start, String route, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visit[i] && start.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visit[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visit = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
}