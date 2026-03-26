class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                matrix[i][j] += matrix[i - 1][j];
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);

            for (int j = 0; j < m; j++) {
                int width = m - j;
                maxArea = Math.max(maxArea, width * matrix[i][j]);
            }
        }
        
        return maxArea;
    }
}