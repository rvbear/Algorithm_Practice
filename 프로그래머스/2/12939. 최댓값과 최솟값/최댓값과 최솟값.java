import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < str.length; i++) {
            int temp = Integer.parseInt(str[i]);
            min = Math.min(temp, min);
            max = Math.max(temp, max);
        }
        return min + " " + max;
    }
}