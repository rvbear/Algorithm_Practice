class Solution {
    int N, M;
    int[][] sum;
    public void operate() {
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sum[i][j] += sum[i-1][j];
            }
        }
        
        for(int j = 1; j < M; j++) {
            for(int i = 0; i < N; i++) {
                sum[i][j] += sum[i][j-1];
            }
        }
    }
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        sum = new int[N+1][M+1];
        
        for(int[] s : skill) {
            int y1 = s[1], x1 = s[2], y2 = s[3], x2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);
            
            sum[y1][x1] += degree;
            sum[y1][x2+1] += degree * -1;
            sum[y2+1][x1] += degree * -1;
            sum[y2+1][x2+1] += degree;
        }
        
        operate();
        
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}