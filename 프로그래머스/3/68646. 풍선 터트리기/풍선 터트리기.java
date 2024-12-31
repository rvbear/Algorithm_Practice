class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int left = a[0], right = a[a.length - 1], answer = 2;
        
        if(a.length == 1) {
            return 1;
        }
        
        for(int i = 1; i < a.length - 1; i++) {
            leftMin[i] = left = Math.min(left, a[i]);
        }
        
        for(int i = a.length - 2; i > 0; i--) {
            rightMin[i] = right = Math.min(right, a[i]);
        }
        
        for(int i = 1; i < a.length - 1; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) {
                continue;
            }
            answer++;
        }
        
        return answer;
    }
}