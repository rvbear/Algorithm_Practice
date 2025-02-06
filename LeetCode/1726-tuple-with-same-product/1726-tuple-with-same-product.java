import java.util.*;

class Solution {
    int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        return combination(n-1, r-1) + combination(n-1, r);
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int mul = nums[i] * nums[j];
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        }

        int sum = 0;
        for (int n : map.values()) {
            if (n == 1) {
                continue;
            }

            sum += combination(n, 2);
        }

        return sum * 8;
    }
}