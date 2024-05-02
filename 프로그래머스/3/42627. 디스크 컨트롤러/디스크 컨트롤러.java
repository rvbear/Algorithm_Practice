import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int index = 0, count = 0, total = 0, end = 0;
        
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }
            
            if(pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] temp = pq.poll();
                total += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            } 
        }
        
        return total / jobs.length;
    }
}