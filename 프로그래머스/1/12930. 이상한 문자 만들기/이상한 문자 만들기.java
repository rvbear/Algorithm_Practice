class Solution {
    public String solution(String s) {
        StringBuilder stb = new StringBuilder();
        int index = 0;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stb.append(c);
                index = 0;
            } else {
                stb.append(index++ % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
            }
        }
        
        return stb.toString();
    }
}
