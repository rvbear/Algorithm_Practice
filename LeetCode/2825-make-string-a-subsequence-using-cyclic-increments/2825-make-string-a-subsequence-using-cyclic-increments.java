class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int sLen = str1.length(), tLen = str2.length();
        int sIdx = 0, tIdx = 0;

        while(sIdx < sLen && tIdx < tLen) {
            char sChar = str1.charAt(sIdx);
            char tChar = str2.charAt(tIdx);

            if(sChar == tChar || (sChar == 'z' && tChar == 'a') || (sChar + 1 == tChar)) {
                sIdx++;
                tIdx++;
            } else {
                sIdx++;
            }
        }

        return tIdx == tLen;
    }
}