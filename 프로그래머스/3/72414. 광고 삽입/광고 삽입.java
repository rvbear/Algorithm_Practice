import java.util.*;

class Solution {
    int toIntTime(String setTime) {
        int[] time = Arrays.stream(setTime.split(":"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        
        return 3600 * time[0] + 60 * time[1] + time[2];
    }
    String toStringTime(int intTime) {
        int h = intTime / 3600;
        int m = (intTime - 3600 * h) / 60;
        int s = intTime - 3600 * h - 60 * m;
        
        return (h < 10 ? "0" : "") + h + ":" +
                (m < 10 ? "0" : "") + m + ":" +
                (s < 10 ? "0" : "") + s;
    }
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toIntTime(play_time);
        int advTime = toIntTime(adv_time);
        int[] times = new int[360000];
        
        for(String log : logs) {
            String[] temp = log.split("-");
            int startTime = toIntTime(temp[0]);
            int endTime = toIntTime(temp[1]);
            
            for(int i = startTime; i < endTime; i++) {
                times[i]++;
            }
        }
        
        int answer = 0;
        long totalTime = 0;
        
        for(int i = 0; i < advTime; i++) {
            totalTime += times[i];
        }
        
        long maxTotalTime = totalTime;
        
        for(int i = advTime; i < playTime; i++) {
            totalTime += times[i] - times[i-advTime];
            if(totalTime > maxTotalTime) {
                maxTotalTime = totalTime;
                answer = i - advTime + 1;
            }
        }
        
        return toStringTime(answer);
    }
}