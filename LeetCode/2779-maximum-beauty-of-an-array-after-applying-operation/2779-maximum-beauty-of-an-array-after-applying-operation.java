class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length == 1) {
            return 1;
        }

        int maxBeauty = 0, maxValue = 0;

        for(int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int[] cnt = new int[maxValue + 1];

        for(int num : nums) {
            cnt[Math.max(num - k, 0)]++;
            cnt[Math.min(num + k + 1, maxValue)]--;
        }

        int curSum = 0;

        for(int val : cnt) {
            curSum += val;
            maxBeauty = Math.max(maxBeauty, curSum);
        }

        return maxBeauty;
    }
}