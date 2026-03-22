class Solution {
    private boolean compare(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[n - 1 - j][i] = mat[i][j];
            }
        }

        return ans;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (compare(mat, target)) {
                return true;
            }

            mat = rotate(mat);
        }

        return false;
    }
}