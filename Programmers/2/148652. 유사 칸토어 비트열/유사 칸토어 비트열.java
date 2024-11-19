class Solution {
    public int count(int n, long l, long r, long index) {
        if(n == 0) {
            return 1;
        }
        
        int num = 0;
        long part = (long)Math.pow(5, n-1);
        
        for(int i = 0; i < 5; i++) {
            if(i == 2 || r < (index + part * i) || (index + part * (i + 1) - 1) < l) {
                continue;
            }
            num += count(n - 1, l, r, index + part * i);
        }
        
        return num;
    }
    public int solution(int n, long l, long r) {
        return count(n, l, r, 1);
    }
}