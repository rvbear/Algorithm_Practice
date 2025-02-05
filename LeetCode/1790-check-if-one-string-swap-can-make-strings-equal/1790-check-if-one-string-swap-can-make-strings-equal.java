import java.util.*;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        char cs1 = '0', cs2 = '0';

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count > 2) {
                    return false;
                }

                if (count == 1) {
                    cs1 = s1.charAt(i);
                    cs2 = s2.charAt(i);
                    continue;
                }

                if (cs1 != s2.charAt(i) || cs2 != s1.charAt(i)) {
                    return false;
                }
            }
        }

        return count == 1 ? false : true;
    }
}