class Solution {
    public int minPartitions(String n) {
        for (char c = '9'; c >= '1'; c--) {
            if (n.indexOf(c) != -1) {
                return c - '0';
            }
        }

        return 0;
    }
}