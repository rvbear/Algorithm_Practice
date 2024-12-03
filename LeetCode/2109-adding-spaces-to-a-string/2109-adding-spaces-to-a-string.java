import java.util.*;

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder stb = new StringBuilder();

        stb.append(s.substring(0, spaces[0]));
        for(int i = 1; i < spaces.length; i++) {
            stb.append(" ").append(s.substring(spaces[i-1], spaces[i]));
        }

        stb.append(" ").append(s.substring(spaces[spaces.length - 1]));

        return stb.toString();
    }
}