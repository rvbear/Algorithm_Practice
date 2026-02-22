class Solution {
    public int binaryGap(int n) {
        n >>= Integer.numberOfTrailingZeros(n);
        
        if (n == 1) {
            return 0;
        }

        int max = 0, gap = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                max = Math.max(max, gap);
                gap = 0;
            } else {
                gap++;
            }

            n >>= 1;
        }

        return max + 1;
    }
}