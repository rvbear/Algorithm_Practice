class Solution {
    static int MOD = 1_000_000_007;

    private int numberOfBits(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }

    public int concatenatedBinary(int n) {
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = ((ans << numberOfBits(i)) % MOD + i) % MOD;
        }

        return (int) ans;
    }
}