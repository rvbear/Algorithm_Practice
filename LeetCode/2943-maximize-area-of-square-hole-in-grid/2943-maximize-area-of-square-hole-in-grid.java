class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxH = 1, maxV = 1, maxI = 1;

        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                maxI++;
            } else {
                maxH = Math.max(maxH, maxI);
                maxI = 1;
            }
        }

        maxH = Math.max(maxH, maxI);

        maxI = 1;

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                maxI++;
            } else {
                maxV = Math.max(maxV, maxI);
                maxI = 1;
            }
        }

        maxV = Math.max(maxV, maxI);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }
}