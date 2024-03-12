class Solution {
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public long solution(int w, int h) {
        long temp = gcd(w, h);
        return ((long)w * h) - (((w / temp) + (h / temp) - 1) * temp);
    }
}