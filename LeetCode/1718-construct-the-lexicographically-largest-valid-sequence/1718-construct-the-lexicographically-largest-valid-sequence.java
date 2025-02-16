import java.util.*;

class Solution {
    boolean backtracking(int[] res, boolean[] visited, int n, int idx) {
        while (idx < res.length && res[idx] != 0) {
            idx++;
        }

        if (idx == res.length) {
            return true;
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i]) {
                continue;
            }

            if (i == 1) {
                res[idx] = 1;
                visited[1] = true;

                if (backtracking(res, visited, n, idx + 1)) {
                    return true;
                }

                res[idx] = 0;
                visited[1] = false;
            } else {
                if (idx + i < res.length && res[idx + i] == 0) {
                    res[idx] = i;
                    res[idx + i] = i;
                    visited[i] = true;
                    
                    if (backtracking(res, visited, n, idx + 1)) {
                        return true;
                    }

                    res[idx] = 0;
                    res[idx + i] = 0;
                    visited[i] = false;
                }
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];

        backtracking(res, visited, n, 0);

        return res;
    }
}