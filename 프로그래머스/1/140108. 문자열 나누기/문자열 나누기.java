class Solution {
    public int solution(String s) {
        int answer = 0, sameCount = 0, differentCount = 0;
        char target = ' ';
        
        for (char c : s.toCharArray()) {
            if (target == ' ') {
                target = c;
                sameCount++;
                continue;
            }
            
            if (target == c) {
                sameCount++;
            } else {
                differentCount++;
            }
            
            if (sameCount == differentCount) {
                answer++;
                target = ' ';
                sameCount = differentCount = 0;
            }
        }
        
        return answer + (sameCount != 0 ? 1 : 0);
    }
}
