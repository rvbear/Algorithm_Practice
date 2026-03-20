class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n - k + 1][m - k + 1];

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                List<Integer> v = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        v.add(grid[x][y]);
                    }
                }

                Collections.sort(v);

                int val = Integer.MAX_VALUE;
                int prev = v.get(0);

                for (int p = 1; p < v.size(); p++) {
                    if (v.get(p) != prev) {
                        val = Math.min(val, v.get(p) - prev);
                    }

                    prev = v.get(p);
                }

                ans[i][j] = (val == Integer.MAX_VALUE) ? 0 : val;
            }
        }

        return ans;
    }
}