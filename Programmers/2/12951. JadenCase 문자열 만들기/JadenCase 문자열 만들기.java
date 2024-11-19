import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i+1);
            if(temp.equals(" ")) {
                answer += " ";
                flag = true;
                continue;
            }
            answer += flag ? temp.toUpperCase() : temp.toLowerCase();
            flag = false;
        }
        
        return answer;
    }
}