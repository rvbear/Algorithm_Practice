class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift : gifts) {
            pq.add(gift);
        }

        for(int i = 0; i < k && pq.peek() > 1; i++) {
            int temp = pq.poll();
            pq.add((int)Math.sqrt(temp));
        }

        long sum = 0;
        for(int gift : pq) {
            sum += gift;
        }

        return sum;
    }
}