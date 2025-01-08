class Solution {
    private boolean isPrefixAndSuffix(String a, String b) {
        if(!b.startsWith(a)) {
            return false;
        }
        if(!b.endsWith(a)) {
            return false;
        }

        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int res = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    res++;
                }
            }
        }

        return res;
    }
}