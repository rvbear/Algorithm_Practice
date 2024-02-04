import java.util.*;

class Solution {
    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> list;
    
    public void dfs(String result) {
        list.add(result);
        
        if(result.length() == 5) {
            return;
        }
        
        for(int i = 0; i < alphabet.length; i++) {
            dfs(result + alphabet[i]);
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("");
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}