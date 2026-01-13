class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            total += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double target = total / 2.0;

        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2.0;
            double cur = 0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];

                double h = Math.max(0, Math.min(l, mid - y));
                cur += h * l;
            }

            if (cur < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }
}