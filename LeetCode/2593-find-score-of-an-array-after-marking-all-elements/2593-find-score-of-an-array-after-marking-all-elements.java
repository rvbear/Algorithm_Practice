class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for(int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean[] visited = new boolean[n];
        long result = 0;

        for(int[] arr : dp) {
            int val = arr[0];
            int idx = arr[1];

            if(!visited[idx]) {
                result += val;

                visited[idx] = true;
                if(idx > 0) {
                    visited[idx-1] = true;
                }
                if(idx < n - 1) {
                    visited[idx+1] = true;
                }
            }
        }

        return result;
    }
}