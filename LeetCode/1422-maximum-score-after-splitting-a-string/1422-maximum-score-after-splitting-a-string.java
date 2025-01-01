class Solution {
    public int maxScore(String s) {
        int total = 0, zeroCnt = 0, oneCnt = 0, max = Integer.MIN_VALUE;

        for(char c : s.toCharArray()) {
            if(c == '1') {
                total++;
            }
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }

            int cur = zeroCnt + (total - oneCnt);
            max = Math.max(cur, max);
        }

        return max;
    }
}