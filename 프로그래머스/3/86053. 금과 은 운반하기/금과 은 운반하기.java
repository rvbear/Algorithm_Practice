class Solution {
    public boolean check(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        long total = 0, totalG = 0, totalS = 0;
        
        for (int i = 0; i < s.length; i++) {
            long count = time / (2L * t[i]);
            
            if (time % (2L * t[i]) >= t[i]) {
                count++;
            }
            
            long sum = count * w[i];
            total += Math.min(sum, g[i] + s[i]);
            totalG += Math.min(sum, g[i]);
            totalS += Math.min(sum, s[i]);
            
            if (total >= a + b && totalG >= a && totalS >= b) {
                return true;
            }
        }
        
        if (total < a + b || totalG < a || totalS < b) {
            return false;
        } 
        
        return true;
    }
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long start = 0;
        long end = (long)Math.pow(10, 14) * 4;
        
        while (start < end) {
            long mid = (start + end) / 2;
            
            if (check(a, b, g, s, w, t, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}
