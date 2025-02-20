import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '0') {
                stb.append('1');
            } else {
                stb.append('0');
            }
        }

        return stb.toString();
    }
}
