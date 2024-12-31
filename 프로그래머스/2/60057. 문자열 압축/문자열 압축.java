class Solution {
    public int solution(String s) {
        int answer = 1000;
        
        for(int i = 1; i <= s.length()/2; i++) {
            int count = 1;
            String zip = s.substring(0, i);
            String result = "";
            
            for(int j = i; j <= s.length(); j += i) {
                String compare = s.substring(j, (j+i) > s.length() ? s.length() : j+i);
                
                if(compare.equals(zip)) {
                    count++;
                } else {
                    result += (count != 1) ? count + zip : zip;
                    zip = compare;
                    count = 1;
                }
            }
            
            result += zip;
            answer = Math.min(answer, result.length());
        }
        
        return s.length() == 1 ? 1 : answer;
    }
}