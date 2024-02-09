class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill_trees.length; i++) {
            StringBuilder stb = new StringBuilder();
            
            for(int j = 0; j < skill_trees[i].length(); j++) {
                String temp = skill_trees[i].substring(j, j + 1);
                
                if(skill.contains(temp)) {
                    stb.append(temp);
                }
            }
            
            if(skill.startsWith(stb.toString())) {
                answer++;
            }
        }
        
        return answer;
    }
}