class Solution {
    public int solution(int n, int w, int num) {
        int cur = (num - 1) % w;
        int left = (n - num) / (2 * w), right = (n - num) % (2 * w);
        return 1 + 2 * left + (right >= 2 * (w - 1 - cur) + 1 ? 1 : 0);
    }
}
