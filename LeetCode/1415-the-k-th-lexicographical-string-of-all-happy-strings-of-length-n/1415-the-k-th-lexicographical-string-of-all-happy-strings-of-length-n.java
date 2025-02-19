import java.util.*;

class Solution {
    int copyN;
    public String dfs(StringBuilder prefix, int n, int k) {
        if (n == 0) {
            return prefix.toString();
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (prefix.length() > 0 && c == prefix.charAt(prefix.length() - 1)) {
                continue;
            }

            int cnt = (int) Math.pow(2, copyN - prefix.length() - 1);

            if (cnt >= k) {
                return dfs(prefix.append(c), n - 1, k);
            } else {
                k -= cnt;
            }
        }

        return "";
    }

    public String getHappyString(int n, int k) {
        copyN = n;
        return dfs(new StringBuilder(), n, k);
    }
}
