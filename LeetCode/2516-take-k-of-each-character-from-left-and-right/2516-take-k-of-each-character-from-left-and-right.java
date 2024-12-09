import java.util.*;
import java.io.*;

class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];

        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        if(Math.min(Math.min(count[0], count[1]), count[2]) < k) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        int l = 0;
        
        for(int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;

            while(Math.min(Math.min(count[0], count[1]), count[2]) < k) {
                count[s.charAt(l) - 'a']++;
                l++;
            }

            result = Math.min(result, s.length() - (r - l + 1));
        }

        return result;
    }
}