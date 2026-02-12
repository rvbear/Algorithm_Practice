class Solution {
    public int longestBalanced(String s) {
        int n = s.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int dis = 0, max = 0;

            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';

                if (freq[idx] == 0) {
                    dis++;
                }

                freq[idx]++;
                max = Math.max(max, freq[idx]);

                int len = j - i + 1;

                if (len == dis * max) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}