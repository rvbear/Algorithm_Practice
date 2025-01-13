class Solution {
    public int minimumLength(String s) {
        int[] alphabet = new int[26];

        for(char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        int res = 0;
        for(int num : alphabet) {
            if(num > 0) {
                res += 1 + ((num % 2 == 0) ? 1 : 0);
            }
        }

        return res;
    }
}