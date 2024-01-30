class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String formation = Long.toString(n, k);
        String[] num = formation.split("0");
        
        for(String s : num) {
            if(s.equals("") || s.equals("1")) continue;
            
            boolean isPrime = true;
            long temp = Long.parseLong(s);
            
            for(int i = 2; i <= Math.sqrt(temp); i++) {
                if(temp % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            answer += isPrime ? 1 : 0;
        }
        
        return answer;
    }
}