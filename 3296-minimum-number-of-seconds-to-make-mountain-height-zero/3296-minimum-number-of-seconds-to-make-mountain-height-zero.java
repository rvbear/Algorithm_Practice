class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1, high = 10_000_000_000_000_000L;

        while (low < high) {
            long mid = (low + high) >> 1;
            long temp = 0;

            for (int i = 0; i < workerTimes.length && temp < mountainHeight; i++) {
                temp += (long) (Math.sqrt((double) mid / workerTimes[i] * 2 + 0.25) - 0.5);
            }

            if (temp >= mountainHeight) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}