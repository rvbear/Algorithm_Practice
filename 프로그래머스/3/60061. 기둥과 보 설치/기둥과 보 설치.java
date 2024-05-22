class Solution {
    boolean[][] pillar, bar;
    
    public boolean checkPillar(int x, int y) {
        return (y == 0) || (y > 0 && pillar[x][y-1]) || (x > 0 && bar[x-1][y] || bar[x][y]); 
    }
    
    public boolean checkBar(int x, int y) {
        return (y > 0 && pillar[x][y-1] || pillar[x+1][y-1]) || (x > 0 && bar[x-1][y] && bar[x+1][y]);
    }
    
    public boolean canDelete(int n) {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j] && !checkPillar(i, j)) {
                    return false;
                } else if(bar[i][j] && !checkBar(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];
        int count = 0;
        
        for(int[] build : build_frame) {
            int x = build[0], y = build[1], type = build[2], order = build[3];
            
            if(type == 0) {
                if(order == 1) {
                    if(checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }
                } else {
                    pillar[x][y] = false;
                    if(!canDelete(n)) {
                        pillar[x][y] = true;
                    } else {
                        count--;
                    }
                }
            } else {
                if(order == 1) {
                    if(checkBar(x, y)) {
                        bar[x][y] = true;
                        count++;
                    }
                } else {
                    bar[x][y] = false;
                    if(!canDelete(n)) {
                        bar[x][y] = true;
                    } else {
                        count--;
                    }
                }
            }
        }
        
        int[][] answer = new int[count][3];
        int index = 0;
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 0;
                }
                if(bar[i][j]) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 1;
                }
            }
        }
        
        return answer;
    }
}