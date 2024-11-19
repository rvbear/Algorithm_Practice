import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++) {
            Stack<Character> stack = new Stack<>();
            int count = 0;
            
            for(int j = 0; j < s[i].length(); j++) {
                stack.push(s[i].charAt(j));
                
                if(stack.size() >= 3) {
                    char third = stack.pop();
                    if(third != '0') {
                        stack.push(third);
                        continue;
                    }

                    char second = stack.pop();
                    if(second != '1') {
                        stack.push(second);
                        stack.push(third);
                        continue;
                    }

                    char first = stack.pop();
                    if(first != '1') {
                        stack.push(first);
                        stack.push(second);
                        stack.push(third);
                        continue;
                    }

                    count++;
                }
            }
            
            StringBuilder stb = new StringBuilder();
            int index = -1, size = stack.size() - 1;
            
            while(!stack.isEmpty()) {
                char value = stack.pop();
                stb.insert(0, value);
                
                if(index == -1 && value == '0') {
                    index = size;
                }
                size--;
            }
            
            int offset = index == -1 ? 0 : ++index;
            
            for(int j = 0; j < count; j++) {
                stb.insert(offset, "110");
            }
            answer[i] = stb.toString();
        }
        return answer;
    }
}