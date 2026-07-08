class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int left = a[0], right = a[n - 1], answer = 2;
        
        if (n == 1) {
            return 1;
        }
        
        for (int i = 1; i < n - 1; i++) {
            leftMin[i] = left = Math.min(left, a[i]);
        }
        
        for (int i = n - 2; i > 0; i--) {
            rightMin[i] = right = Math.min(right, a[i]);
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (a[i] > leftMin[i] && a[i] > rightMin[i]) {
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}
