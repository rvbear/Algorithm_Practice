class Solution {
    public long check(int x, int[] diffs, int[] times) {
        long time = (diffs[0] - x) < 0 ? times[0] : (diffs[0] - x) * times[0] + times[0];
        
        for(int i = 1; i < diffs.length; i++) {
            time += (diffs[i] - x) < 0 ? times[i] : ((times[i-1] + times[i]) * (diffs[i] - x) + times[i]);
        }
        
        return time;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1, end = 100000;
        
        while(start < end) {
            int mid = (start + end) / 2;
            long temp = check(mid, diffs, times);
            
            if(temp <= limit) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
}