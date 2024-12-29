class Solution {
    private int find(int i, int j, String target, int[][] alphabet, int[][] dp, int mod) {
        if(j == target.length()) {
            return 1;
        }

        if(i == alphabet.length) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        long cnt = find(i+1, j, target, alphabet, dp, mod);
        cnt %= mod;
        cnt += (1L * alphabet[i][target.charAt(j)-'a'] * find(i+1, j+1, target, alphabet, dp, mod)) % mod;
        cnt %= mod;

        return dp[i][j] = (int)cnt; 
    }
    public int numWays(String[] words, String target) {
        int n = words.length;
        int m = words[0].length();
        int mod = 1000000007;
        int[][] alphabet = new int[m][26];

        for(String word : words) {
            for(int j = 0; j < m; j++) {
                alphabet[j][word.charAt(j) - 'a']++;
            }
        }

        int[][] dp = new int[m][target.length()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return find(0, 0, target, alphabet, dp, mod);
    }
}