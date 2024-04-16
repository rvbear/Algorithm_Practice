class Solution {
    public int getDistance(int sx, int sy, int ex, int ey) {
        return (int)(Math.pow(sx - ex, 2) + Math.pow(sy - ey, 2));
    }
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            
            int temp, minLen = Integer.MAX_VALUE;
            
            if(!(x <= startX && y == startY)) {
                temp = getDistance(startX, startY, x * (-1), y);
                minLen = Math.min(minLen, temp);
            }
            
            if(!(x >= startX && y == startY)) {
                temp = getDistance(startX, startY, m + (m - x), y);
                minLen = Math.min(minLen, temp);
            }
            
            if(!(x == startX && y >= startY)) {
                temp = getDistance(startX, startY, x, n + (n - y));
                minLen = Math.min(minLen, temp);
            }
            
            if(!(x == startX && y <= startY)) {
                temp = getDistance(startX, startY, x, y * (-1));
                minLen = Math.min(minLen, temp);
            }
            
            answer[i] = minLen;
        }
        
        return answer;
    }
}