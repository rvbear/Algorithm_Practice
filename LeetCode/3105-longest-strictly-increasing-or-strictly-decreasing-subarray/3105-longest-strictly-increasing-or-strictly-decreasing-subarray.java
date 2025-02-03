class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int upCnt = 1, downCnt = 1, max = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                upCnt = 1;
                downCnt++;
            } else if (nums[i-1] < nums[i]) {
                downCnt = 1;
                upCnt++;
            } else {
                upCnt = 1;
                downCnt = 1;
            }

            max = Math.max(max, Math.max(upCnt, downCnt));
        }

        return max;
    }
}