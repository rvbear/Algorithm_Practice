class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];
        
        for(int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        
        for(int i = 0; i < count.length; i++) {
            if(count[i] <= answer) {
                continue;
            }
            
            int temp = 0;
            for(int j = 0; j < a.length - 1; j++) {
                if(a[j] != a[j+1] && (i == a[j] || i == a[j+1])) {
                    temp++;
                    j++;
                }
            }
            
            answer = Math.max(answer, temp);
        }
        
        return answer * 2;
    }
}