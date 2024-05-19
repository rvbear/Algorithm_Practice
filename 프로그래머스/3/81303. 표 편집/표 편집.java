import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> s = new Stack<>();
        int size = n;
        
        for(String query : cmd) {
            char key = query.charAt(0);
            switch(key) {
                case 'U':
                    k -= Integer.valueOf(query.substring(2));
                    break;
                case 'D':
                    k += Integer.valueOf(query.substring(2));
                    break;
                case 'C':
                    s.push(k);
                    size--;
                    if(k == size) {
                        k--;
                    }
                    break;
                case 'Z':
                    int temp = s.pop();
                    if(temp <= k) {
                        k++;
                    }
                    size++;
                    break;
            }
        }
        
        StringBuilder stb = new StringBuilder();
        
        for(int i = 0; i < size; i++) {
            stb.append('O');
        }
        
        while(!s.isEmpty()) {
            stb.insert(s.pop().intValue(), 'X');
        }
        
        return stb.toString();
    }
}