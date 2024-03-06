import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int index = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);
        int[][] sum = new int[index][3];
        int dPoint = 0, iPoint = 0, sPoint = 0;
        
        for(int i = 0; i < minerals.length; i += 5) {
            if(i / 5 == index) break;
            
            for(int j = i; j < i+5; j++) {
                String m = minerals[j];
                
                if(m.equals("diamond")) {
                    dPoint += 1;
                    iPoint += 5;
                    sPoint += 25;
                } else if(m.equals("iron")) {
                    dPoint += 1;
                    iPoint += 1;
                    sPoint += 5;
                } else {
                    dPoint += 1;
                    iPoint += 1;
                    sPoint += 1;
                }
                
                if(j == minerals.length - 1) break;
            }
            
            sum[i/5][0] += dPoint;
            sum[i/5][1] += iPoint;
            sum[i/5][2] += sPoint;
            
            dPoint = iPoint = sPoint = 0;
        }
        
        Arrays.sort(sum, (o1, o2) -> o2[2] - o1[2]);
        
        for(int i = 0; i < index; i++) {
            if(picks[0] != 0) {
                answer += sum[i][0];
                picks[0]--;
            } else if(picks[1] != 0) {
                answer += sum[i][1];
                picks[1]--;
            } else {
                answer += sum[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}