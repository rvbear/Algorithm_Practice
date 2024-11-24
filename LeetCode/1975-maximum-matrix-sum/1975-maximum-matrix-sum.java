class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int count = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < 0) {
                    count++;
                }
                int temp = Math.abs(matrix[i][j]);
                min = Math.min(min, temp);
                sum += temp;
            }
        }

        return count % 2 == 0 ? sum : sum - 2 * min;
    }
}