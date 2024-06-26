class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++) {
            floyd[results[i][0]][results[i][1]] = 1;
            floyd[results[i][1]][results[i][0]] = -1;
        }
        
        for(int i = 0; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    if(floyd[i][k] == -1 && floyd[k][j] == -1) {
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(floyd[i][j] != 0) {
                    count++;
                }
            }
            if(count == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}