import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int AIndex = 0, BIndex = 0;
        while(BIndex < B.length) {
            if(A[AIndex] < B[BIndex]) {
                AIndex++;
                answer++;
            }
            BIndex++;
        }
        
        return answer;
    }
}