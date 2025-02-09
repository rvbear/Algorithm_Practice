import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long total = (long)n * (n-1) / 2;
        Map<Integer, Long> diffCnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            total -= diffCnt.getOrDefault(diff, 0L);
            diffCnt.put(diff, diffCnt.getOrDefault(diff, 0L) + 1);
        }

        return total;
    }
}