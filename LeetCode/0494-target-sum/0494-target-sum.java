class Solution {
    private int dfs(int[] arr, int target, int idx, int sum) {
        if(idx >= arr.length) {
            return sum == target ? 1 : 0;
        }

        int min = dfs(arr, target, idx + 1, sum - arr[idx]);
        int add = dfs(arr, target, idx + 1, sum + arr[idx]);

        return min + add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }
}