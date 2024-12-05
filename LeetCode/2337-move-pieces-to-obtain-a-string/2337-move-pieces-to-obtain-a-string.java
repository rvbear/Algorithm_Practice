class Solution {
    public boolean canChange(String start, String target) {
        if(start.equals(target)) {
            return true;
        }

        int idxL = 0, idxR = 0;

        for(int i = 0; i < start.length(); i++) {
            char cur = start.charAt(i);
            char goal = target.charAt(i);

            if(cur == 'R') {
                if(idxL > 0) {
                    return false;
                }
                idxR++;
            }

            if(goal == 'L') {
                if(idxR > 0) {
                    return false;
                }
                idxL++;
            }

            if(cur == 'L') {
                if(idxL == 0) {
                    return false;
                }
                idxL--;
            }

            if(goal == 'R') {
                if(idxR == 0) {
                    return false;
                }
                idxR--;
            }
        }

        return idxL == 0 && idxR == 0;
    }
}