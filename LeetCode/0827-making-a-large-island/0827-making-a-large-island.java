import java.util.*;

class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int dfs(int[][] grid, int x, int y, int depth) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] != 1) {
            return 0;
        }

        grid[x][y] = depth;
        int cnt = 1;
        for (int[] d : dir) {
            cnt += dfs(grid, x + d[0], y + d[1], depth);
        }

        return cnt;
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        List<Integer> key = new ArrayList<>();
        int depth = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, depth);
                    key.add(size);
                    depth++;
                }
            }
        }

        if (key.isEmpty()) {
            return 1;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int sum = 1;
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        
                        if (x < 0 || y < 0 || x > n-1 || y > n-1 || grid[x][y] < 2) {
                            continue;
                        }

                        int islandId = grid[x][y];
                        if (!seen.contains(islandId)) {
                            sum += key.get(islandId - 2);
                            seen.add(islandId);
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }

        return max == 0 ? n * n : max;
    }
}