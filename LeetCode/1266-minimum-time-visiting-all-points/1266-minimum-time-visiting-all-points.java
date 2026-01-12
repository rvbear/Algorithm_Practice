class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sec = 0, n = points.length;

        for (int i = 1; i < n; i++) {
            int x1 = points[i-1][0], y1 = points[i-1][1];
            int x2 = points[i][0], y2 = points[i][1];

            while (x1 != x2 && y1 != y2) {
                if (x1 < x2 && y1 < y2) {
                    x1 += 1;
                    y1 += 1;
                } else if (x1 < x2 && y1 > y2) {
                    x1 += 1;
                    y1 -= 1;
                } else if (x1 > x2 && y1 < y2) {
                    x1 -= 1;
                    y1 += 1;
                } else {
                    x1 -= 1;
                    y1 -= 1;
                }

                sec += 1;
            }

            if (x1 == x2) {
                sec += y1 > y2 ? y1 - y2 : y2 - y1;
            } else if (y1 == y2) {
                sec += x1 > x2 ? x1 - x2 : x2 - x1;
            }
        }

        return sec;
    }
}