import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (num < k) {
                pq.add(num);
            }
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            cnt++;

            if (pq.isEmpty()) {
                break;
            }

            int y = pq.poll();
            long val = 2L * x + y;

            if (val < k) {
                pq.add((int)val);
            }
        }

        return cnt;
    }
}