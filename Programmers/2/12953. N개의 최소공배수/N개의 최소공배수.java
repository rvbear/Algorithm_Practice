class Solution {
    public static int GCD(int a, int b) {
        if(a % b == 0) return b;
        return GCD(b, a % b);
    }
    
    public int solution(int[] arr) {
        if(arr.length == 1) return arr[0];
        
        int gcd = GCD(arr[0], arr[1]);
        int answer = (arr[0] * arr[1]) / gcd;
        
        if(arr.length == 2) return answer;
        
        for(int i = 2; i < arr.length; i++) {
            gcd = GCD(answer, arr[i]);
            answer = (answer * arr[i]) / gcd;
        }
        
        return answer;
    }
}