class Solution {
    public int minimumDeletions(String s) {
        int before = 0, delete = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                before += 1;
            } else if (before > 0) {
                before -= 1;
                delete += 1;
            }
        }

        return delete;
    }
}