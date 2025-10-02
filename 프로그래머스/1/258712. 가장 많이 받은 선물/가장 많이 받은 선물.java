import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> friendMap = new HashMap<>();
        int[] giftDegree = new int[friends.length];
        int[][] giftGraph = new int[friends.length][friends.length];
        
        for(int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }
        
        for(String gift : gifts) {
            String[] name = gift.split(" ");
            giftDegree[friendMap.get(name[0])]++;
            giftDegree[friendMap.get(name[1])]--;
            giftGraph[friendMap.get(name[0])][friendMap.get(name[1])]++;
        }
        
        for(int i = 0; i < friends.length; i++) {
            int num = 0;
            for(int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                
                if(giftGraph[i][j] > giftGraph[j][i] || (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])) {
                    num++;
                }
            }
            
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
}