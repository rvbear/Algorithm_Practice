class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int x = 0; x <= d; x += k) {
            long dd = (long)d * d;
            long xx = (long)x * x;
            long y = (long)Math.sqrt(dd - xx);
            answer += y / k + 1;
        }
        
        return answer;
    }
}