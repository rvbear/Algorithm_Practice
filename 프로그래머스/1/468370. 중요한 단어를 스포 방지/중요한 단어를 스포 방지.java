import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        StringBuilder blind = new StringBuilder(message);
        
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                if (blind.charAt(i) != ' ') {
                    blind.setCharAt(i, '*');
                }
            }
        }
        
        for (String word : blind.toString().split(" ")) {
            set.add(word);
        }
        
        for (String word : message.split(" ")) {
            if (!set.contains(word)) {
                answer++;
                set.add(word);
            }
        }
        
        return answer;
    }
}
