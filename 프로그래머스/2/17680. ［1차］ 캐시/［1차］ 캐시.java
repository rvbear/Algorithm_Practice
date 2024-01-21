import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < cities.length && cacheSize > 0; i++) {
            if(list.contains(cities[i].toLowerCase()) && list.size() != 0) {
                list.add(list.remove(list.indexOf(cities[i].toLowerCase())));
                answer += 1;
            } else if(list.size() < cacheSize) {
                list.add(cities[i].toLowerCase());
                answer += 5;
            } else {
                list.remove(0);
                list.add(cities[i].toLowerCase());
                answer += 5;
            }
        }
        
        return answer = answer > 0 ? answer : 5 * cities.length;
    }
}