class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, m = values[0];
        int res = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++) {
            if(values[i] - i + m > res) {
                res = values[i] - i + m;
            }

            if(values[i] + i > m) {
                m = values[i] + i;
            }
        }

        return res;
    }
}