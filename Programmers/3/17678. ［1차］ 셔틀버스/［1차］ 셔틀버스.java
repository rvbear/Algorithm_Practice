import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String record : timetable) {
            pq.add(Integer.parseInt(record.substring(0, 2)) * 60 + Integer.parseInt(record.substring(3)));
        }
        
        int startTime = 9 * 60, lastTime = 0, total = 0;
        for(int i = 0; i < n; i++) {
            total = 0;
            while(!pq.isEmpty()) {
                int currentTime = pq.peek();
                if(currentTime <= startTime && total < m) {
                    pq.poll();
                    total++;
                } else {
                    break;
                }
                
                lastTime = currentTime - 1;
            }
            startTime += t;
        }
        
        if(total < m) {
            lastTime = startTime - t;
        }
        
        String hour = String.format("%02d", lastTime / 60);
        String min = String.format("%02d", lastTime % 60);
        return hour + ":" + min;
    }
}