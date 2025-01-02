class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length, m = queries.length;
        int[] prefix = new int[n+1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for(int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i];

            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                prefix[i+1]++;
            }
        }

        int[] res = new int[m];

        for(int i = 0; i < m; i++) {
            res[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }

        return res;
    }
}