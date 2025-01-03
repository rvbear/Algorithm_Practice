class Solution {
    public String solution(String newId) {
        String answer = newId.toLowerCase();
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        if(answer.equals("")) {
            answer += "a";
        }
        
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        if(answer.length() < 3) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        
        return answer;
    }
}