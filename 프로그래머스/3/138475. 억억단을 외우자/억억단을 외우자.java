class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] count = new int[e+1];
        
        for(int i = 1; i < e+1; i++) {
            for(int j = 1; j <= e/i; j++) {
                count[i*j]++;
            }
        }

        int[] max = new int[e+1];
        max[e] = e;
        
        for(int i = e-1; i > 0; i--) {
            max[i] = (count[i] >= count[max[i+1]]) ? i : max[i+1];
        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = max[starts[i]];
        }
        
        return answer;
    }
}