import java.util.*;

class Solution {
    static Map<String, List<Integer>> map;
    public static void dfs(String[] info, String s, int depth) {
        if(depth == 4) {
            if(!map.containsKey(s)) {
                List<Integer> list = new ArrayList<>();
                map.put(s, list);
            }
            map.get(s).add(Integer.parseInt(info[4]));
            return;
        }
        dfs(info, s + "-", depth + 1);
        dfs(info, s + info[depth], depth + 1);
    }
    public static int search(String query) {
        query = query.replaceAll(" and ", "");
        String[] q = query.split(" ");
        
        if(!map.containsKey(q[0])) {
            return 0;
        }
        
        List<Integer> list = map.get(q[0]);
        int start = 0, end = list.size() - 1, score = Integer.parseInt(q[1]);
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return list.size() - start;
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        for(int i = 0; i < info.length; i++) {
            dfs(info[i].split(" "), "", 0);
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for(int i = 0; i < query.length; i++) {
            answer[i] = search(query[i]);
        }
        
        return answer;
    }
}