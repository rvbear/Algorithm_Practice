class Solution {
    private static int counter(String s, char start) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && s.charAt(i) != start) {
                cnt++;
            } else if (i % 2 == 1 && s.charAt(i) == start) {
                cnt++;
            }
        }

        return cnt;
    }

    public int minOperations(String s) {
        return Math.min(counter(s, '0'), counter(s, '1'));
    }
}