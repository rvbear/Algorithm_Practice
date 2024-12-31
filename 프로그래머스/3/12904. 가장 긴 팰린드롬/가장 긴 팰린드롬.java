class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public int solution(String s) {
        for(int i = s.length(); i > 0; i--) {
            for(int j = 0; j+i <= s.length(); j++) {
                if(isPalindrome(s, j, i + j - 1)) {
                    return i;
                }
            }
        }

        return 0;
    }
}