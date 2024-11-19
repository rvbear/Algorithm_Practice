import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0, cam = Integer.MIN_VALUE;
        
        Arrays.sort(routes, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        for(int[] route : routes) {
            if(cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}