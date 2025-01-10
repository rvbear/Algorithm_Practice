class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] max = new int[26];
        int[] temp = new int[26];

        for(String word : words2) {
            Arrays.fill(temp, 0);
            for(char c : word.toCharArray()) {
                temp[c - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                max[i] = Math.max(max[i], temp[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for(String word : words1) {
            Arrays.fill(temp, 0);
            for(char c : word.toCharArray()) {
                temp[c - 'a']++;
            }

            boolean flag = true;
            for(int i = 0; i < 26; i++) {
                if(max[i] > temp[i]) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                res.add(word);
            }
        }

        return res;
    }
}