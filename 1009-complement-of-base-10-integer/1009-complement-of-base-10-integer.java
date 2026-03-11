class Solution {
    public int bitwiseComplement(int n) {
        int mask = (Integer.highestOneBit(Math.max(n, 1)) << 1) - 1;
        return n ^ mask;
    }
}