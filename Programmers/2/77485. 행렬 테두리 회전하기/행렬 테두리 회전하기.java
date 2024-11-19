class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int value = 1;
        
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                matrix[i][j] = value++;
        
        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            int temp = matrix[x1][y2];
            answer[i] = temp;
            
            for(int y = y2 - 1; y >= y1; y--) {
                answer[i] = Math.min(answer[i], matrix[x1][y]);
                matrix[x1][y+1] = matrix[x1][y];
            }
            
            for(int x = x1 + 1; x <= x2; x++) {
                answer[i] = Math.min(answer[i], matrix[x][y1]);
                matrix[x-1][y1] = matrix[x][y1];
            }
            
            for(int y = y1 + 1; y <= y2; y++) {
                answer[i] = Math.min(answer[i], matrix[x2][y]);
                matrix[x2][y-1] = matrix[x2][y];
            }
            
            for(int x = x2 - 1; x >= x1; x--) {
                answer[i] = Math.min(answer[i], matrix[x][y2]);
                matrix[x+1][y2] = matrix[x][y2];
            }
            
            matrix[x1+1][y2] = temp;
        }
        
        return answer;
    }
}