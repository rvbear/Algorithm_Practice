import java.util.*;

class Solution {
    public String clearDigits(String s) {
        StringBuilder stb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (stb.length() > 0) {
                    stb.deleteCharAt(stb.length() - 1);
                }
            } else {
                stb.append(c);
            }
        }

        return stb.toString();
    }
}