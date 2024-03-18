class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill_trees.length; i++) {
            String temp = "";
            
            for(int j = 0; j < skill_trees[i].length(); j++) {
                String s = skill_trees[i].substring(j, j + 1);
                
                if(skill.contains(s)) {
                    temp += s;
                }
            }
            
            if(skill.startsWith(temp)) {
                answer++;
            }
        }
        
        return answer;
    }
}