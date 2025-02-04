import java.util.*;

class Solution {
    public int maxAscendingSum(int[] nums) {
        int max, sum; 
        max = sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                sum += nums[i];
                continue;
            }

            max = Math.max(max, sum);
            sum = nums[i];
        }

        return Math.max(max, sum);
    }
}