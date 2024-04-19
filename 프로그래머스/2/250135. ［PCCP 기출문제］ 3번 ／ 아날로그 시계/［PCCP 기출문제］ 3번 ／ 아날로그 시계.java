class Solution {
    public int changeSec(int h, int m, int s) {
        return 3600 * h + 60 * m + s;
    }
    public boolean alarmNow(int time) {
        return time * 59 % 3600 == 0 || time * 719 % 43200 == 0;
    }
    public int cal(int time) {
        int ms = time * 59 / 3600;
        int hs = time * 719 / 43200;
        int all = 43200 <= time ? 2 : 1;
        
        return ms + hs - all;
    }
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = changeSec(h1, m1, s1);
        int end = changeSec(h2, m2, s2);
        
        return cal(end) - cal(start) + (alarmNow(start) ? 1 : 0);
    }
}