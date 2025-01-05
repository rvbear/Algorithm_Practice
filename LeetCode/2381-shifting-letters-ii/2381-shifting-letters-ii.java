class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n+1];

        for(int[] temp : shifts) {
            int start = temp[0], end = temp[1], dir = temp[2];
            shift[start] += (dir == 1 ? 1 : -1);
            
            if(end+1 < n) {
                shift[end+1] -= (dir == 1 ? 1 : -1);
            }
        }

        int cur = 0;
        for(int i = 0; i < n; i++) {
            cur += shift[i];
            shift[i] = cur;
        }

        StringBuilder res = new StringBuilder(s);
        for(int i = 0; i < n; i++) {
            int net = (shift[i] % 26 + 26) % 26;
            res.setCharAt(i, (char)('a' + (s.charAt(i) - 'a' + net) % 26));
        }

        return res.toString();
    }
}