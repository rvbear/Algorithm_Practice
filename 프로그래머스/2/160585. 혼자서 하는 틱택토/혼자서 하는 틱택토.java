class Solution {
    char[][] map;
    public int win(char c) {
        int winCount = 0;
        
        for(int i = 0; i < 3; i++) {
            if(map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                winCount++;
            }
            if(map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                winCount++;
            }
        }
        
        if(map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            winCount++;
        }
        if(map[2][0] == c && map[2][0] == map[1][1] && map[1][1] == map[0][2]) {
            winCount++;
        }
        
        return winCount;
    }
    public int solution(String[] board) {
        map = new char[3][3];
        int oCount = 0, xCount = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'O') {
                    oCount++;
                } else if(map[i][j] == 'X') {
                    xCount++;
                }
            }
        }
        
        if(xCount > oCount || (oCount - xCount) > 1) {
            return 0;
        }
        
        if(win('O') > 0 && win('X') > 0) {
            return 0;
        }
        
        if(win('O') > 0) {
            return oCount - xCount == 1 ? 1 : 0;
        }
        
        if(win('X') > 0) {
            return oCount - xCount == 0 ? 1 : 0;
        }
        
        return 1;
    }
}