import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> list = new ArrayList<>();
        
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(int i = 0; i < line.length; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            
            for(int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long down = a * d - b * c;
                long upX = b * f - e * d;
                long upY = e * c - a * f;
                
                if(down != 0) {
                    double x = upX / (double)down;
                    double y = upY / (double)down;
                    
                    if(x == Math.ceil(x) && y == Math.ceil(y)) {
                        list.add(new long[]{(long)x, (long)y});
                        
                        minX = Math.min(minX, (long)x);
                        minY = Math.min(minY, (long)y);
                        maxX = Math.max(maxX, (long)x);
                        maxY = Math.max(maxY, (long)y);
                    }
                }
            }
        }
        
        boolean[][] boolTemp = new boolean[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        
        for(long[] temp: list) {
            int x = (int)(temp[0] - minX);
            int y = (int)(temp[1] - maxY);
            
            boolTemp[Math.abs(y)][Math.abs(x)] = true;
        }
        
        answer = new String[boolTemp.length];
        int index = 0;
        
        for(boolean[] bt : boolTemp) {
            StringBuilder stb = new StringBuilder();
            
            for(boolean b : bt) {
                stb.append(b ? "*" : ".");
            }
            
            answer[index++] = stb.toString();
        }
        
        return answer;
    }
}