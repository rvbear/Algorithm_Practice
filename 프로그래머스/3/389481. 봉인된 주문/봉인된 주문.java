import java.util.*;

class Solution {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    public long stringToLong(String str) {
        int len = str.length();
        long num = 0;
        
        for (int i = 0; i < len; i++) {
            int idx = 0;
            
            for (int j = 0; j < alphabet.length(); j++) {
                if (str.charAt(i) == alphabet.charAt(j)) {
                    idx = j + 1;
                    break;
                }
            }
            
            if (i == len - 1) {
                num += idx;
            } else {
                num += Math.pow(26, len - i - 1) * idx;
            }
        }
        
        return num - 1;
    }
    
    public String longToString(long num) {
        if (num >= 0 && num < 26) {
            return String.valueOf(alphabet.charAt((int)num));
        } else {
            return longToString(num / 26 - 1) + longToString(num % 26);
        }
    }
    
    public String solution(long n, String[] bans) {
        Arrays.sort(bans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        
        n--;
        
        for (int i = 0; i < bans.length; i++) {
            long num = stringToLong(bans[i]);
            
            if (num <= n) {
                n++;
            }
        }
        
        return longToString(n);
    }
}
