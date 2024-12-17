class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] alphabet = new int[26];

        for(char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        StringBuilder stb = new StringBuilder();
        int idx = -1;

        for(int i = 25; i >= 0; i--) {
            if(alphabet[i] == 0) {
                continue;
            }

            if(idx > 0) {
                stb.append((char)('a' + i));
                alphabet[i]--;
                i = idx;
                idx = -1;
            } else {
                for(int j = 0; j < repeatLimit && alphabet[i] > 0; j++, alphabet[i]--) {
                    stb.append((char)('a' + i));
                }

                if(alphabet[i] > 0) {
                    idx = i + 1;
                }
            }
        }

        return stb.toString();
    }
}