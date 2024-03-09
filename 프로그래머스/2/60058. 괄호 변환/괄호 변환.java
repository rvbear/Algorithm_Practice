import java.util.*;

class Solution {
    public boolean check(String p) {
        Stack<Character> s = new Stack<>();
        
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if(c == '(') s.add(c);
            else {
                if(s.isEmpty()) return false;
                s.pop();
            }
        }
        
        return s.isEmpty() ? true : false;
    }
    public String dfs(String p) {
        if(p.length() == 0) return p;
        
        String u = "", v = "";
        int open = 0, close = 0;
        
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if(c == '(') open++; 
            else close++;
            
            if(open > 0 && open == close) {
                u = p.substring(0, i+1);
                v = i < p.length() - 1 ? p.substring(i+1, p.length()) : "";
                break;
            }
        }
        
        if(check(u)) return u + dfs(v);
        else {
            String temp = "(" + dfs(v) + ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            temp += u;
            
            return temp;
        }
    }
    public String solution(String p) {
        return check(p) ? p : dfs(p);
    }
}