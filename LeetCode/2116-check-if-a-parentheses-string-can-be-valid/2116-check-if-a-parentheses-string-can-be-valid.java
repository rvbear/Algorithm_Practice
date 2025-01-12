class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        
        if(n % 2 != 0) {
            return false;
        }

        int openCnt = 0;
        for(int i = 0; i < n; i++) {
            if(locked.charAt(i) == '0' || s.charAt(i) == '(') {
                openCnt++;
            } else {
                openCnt--;
            }

            if(openCnt < 0) {
                return false;
            }
        }

        int closeCnt = 0;
        for(int i = n-1; i >= 0; i--) {
            if(locked.charAt(i) == '0' || s.charAt(i) == ')') {
                closeCnt++;
            } else {
                closeCnt--;
            }

            if(closeCnt < 0) {
                return false;
            }
        }

        return true;
    }
}