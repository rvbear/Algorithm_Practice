class Solution {
    public int bitwiseComplement(int n) {
        int mask = (Integer.highestOneBit(n) << 1) - 1;
        return n ^ mask;
    }
}