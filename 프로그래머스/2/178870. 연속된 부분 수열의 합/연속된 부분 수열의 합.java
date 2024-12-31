class Solution {
    public int[] solution(int[] sequence, int k) {
        int min = Integer.MAX_VALUE, sum = 0, start = 0;
        int[] answer = new int[2];
        
        for(int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            while(sum > k) {
                sum -= sequence[start++];
            }
            if(sum == k) {
                if(min > (i - start)) {
                    min = i - start;
                    answer[0] = start;
                    answer[1] = i;
                }
            }
        }
        
        return answer;
    }
}