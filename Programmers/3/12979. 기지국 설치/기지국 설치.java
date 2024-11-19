class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, now = 1, index = 0;

        while(now <= n) {
            if(index >= stations.length || now < stations[index] - w) {
                answer++;
                now = now + 2 * w + 1;
            } else {
                now = stations[index] + w + 1;
                index++;
            }
        }

        return answer;
    }
}