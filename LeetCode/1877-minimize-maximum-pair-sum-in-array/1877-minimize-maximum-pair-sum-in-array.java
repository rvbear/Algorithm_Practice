class Solution {
    public int minPairSum(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] freq = new int[100001];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }

            freq[nums[i]]++;
        }

        int maxSum = 0, left = min, right = max;
        while (left <= right) {
            if (freq[left] == 0) {
                left++;
            } else if (freq[right] == 0) {
                right--;
            } else {
                maxSum = Math.max(maxSum, left + right);
                freq[left]--;
                freq[right]--;
            }
        }

        return maxSum;
    }
}