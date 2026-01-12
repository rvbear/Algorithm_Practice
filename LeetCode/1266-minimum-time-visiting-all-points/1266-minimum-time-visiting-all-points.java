class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sec = 0, n = points.length;

        for (int i = 1; i < n; i++) {
            sec += Math.max(Math.abs(points[i-1][0] - points[i][0]), Math.abs(points[i-1][1] - points[i][1]));
        }

        return sec;
    }
}