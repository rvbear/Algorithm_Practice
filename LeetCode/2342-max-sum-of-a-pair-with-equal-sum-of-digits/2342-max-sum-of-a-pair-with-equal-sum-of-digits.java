import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        int[] memo = new int[82];
        int ans = -1;

        for (int num : nums) {
            int temp = num;
            int sum = 0;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            int prev = memo[sum];

            if (prev != 0) {
                ans = Math.max(ans, num + prev);
                memo[sum] = Math.max(prev, num);
            } else {
                memo[sum] = num;
            }
        }

        return ans;
    }
}