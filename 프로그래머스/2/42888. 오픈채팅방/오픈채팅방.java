import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int count = 0, index = 0;
        String[] answer;
        Map<String, String> map = new HashMap<>();
        
        for(String infos : record) {
            String[] info = infos.split(" ");
            
            if(info[0].equals("Leave")) {
                continue;
            }
            
            map.put(info[1], info[2]);
            count += info[0].equals("Change") ? 1 : 0;
        }
        
        answer = new String[record.length - count];
        
        for(String infos : record) {
            String[] info = infos.split(" ");
            
            if(info[0].equals("Enter")) {
                answer[index++] = map.get(info[1]) + "님이 들어왔습니다.";
            } else if(info[0].equals("Leave")) {
                answer[index++] = map.get(info[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}