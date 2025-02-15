import java.util.*;

class Solution {
    public boolean canPartition(int num, int target) {
        if (num < target || target < 0) {
            return false;
        }

        if (num == target) {
            return true;
        }

        return (canPartition(num / 10, target - (num % 10)) || canPartition(num / 100, target - (num % 100)) || canPartition(num / 1000, target - (num % 1000)));
    }

    public int punishmentNumber(int n) {
        int res = 0;

        for (int i = 1; i < n+1; i++) {
            int temp = i * i;

            if (canPartition(temp, i)) {
                res += temp;
            }
        }

        return res;
    }
}