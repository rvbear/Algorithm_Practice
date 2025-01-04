class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] right = new int[26];
        for(char c : s.toCharArray()) {
            right[c - 'a']++;
        }

        int[] left = new int[26];
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            int t = s.charAt(i) - 'a';
            right[t]--;

            for(int j = 0; j < 26; j++) {
                if(left[j] > 0 && right[j] > 0) {
                    set.add(26 * t + j);
                }
            }

            left[t]++;
        }

        return set.size();
    }
}