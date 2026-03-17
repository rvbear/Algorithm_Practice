class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int maxArea = 0;
        int[] h = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    h[j]++;
                } else {
                    h[j] = 0;
                }
            }

            int[] sh = h.clone();
            Arrays.sort(sh);

            for (int j = m - 1; j >= 0; j--) {
                if (sh[j] == 0) {
                    break;
                }

                maxArea = Math.max(maxArea, sh[j] * (m - j));
            }
        }

        return maxArea;
    }
}