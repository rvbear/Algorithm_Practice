class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        for (int i = 0; i < arr.length; i++) {
            int n = Integer.bitCount(arr[i]);
            pq.offer(new int[] {n, arr[i]});
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            arr[idx++] = pq.poll()[1];
        }

        return arr;
    }
}