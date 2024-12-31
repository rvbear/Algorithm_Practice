class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health, sequence = 0, max = attacks[attacks.length - 1][0], index = 0;
        
        for(int i = 1; i <= max; i++) {
            if(answer > health) answer = health;
            
            if(attacks[index][0] == i) {
                answer -= attacks[index++][1];
                sequence = 0;
                
                if(answer < 0) return -1;
                
                continue;
            }
            
            answer += bandage[1];
            sequence++;
            
            if(sequence == bandage[0]) {
                answer += bandage[2];
                sequence = 0;
            }
        }
        
        return answer > 0 ? answer : -1;
    }
}