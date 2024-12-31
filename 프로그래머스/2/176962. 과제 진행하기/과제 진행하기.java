import java.util.*;

class Solution {
    static class Homework {
        String name;
        int start, doing;
        
        public Homework(String[] info) {
            this.name = info[0];
            String[] time = info[1].split(":");
            this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            this.doing = Integer.parseInt(info[2]);
        }
    }
    public String[] solution(String[][] plans) {
        Homework[] hw = new Homework[plans.length];
        
        for(int i = 0; i < plans.length; i++) 
            hw[i] = new Homework(plans[i]);
        
        Arrays.sort(hw, (o1, o2) -> o1.start - o2.start);
        
        Stack<Homework> stop = new Stack<>();
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < plans.length - 1; i++) {
            Homework now = hw[i];
            Homework next = hw[i+1];
            
            int endTime = now.start + now.doing;
            
            if(endTime > next.start) {
                now.doing = endTime - next.start;
                stop.push(now);
                continue;
            }
            
            answer.add(now.name);
            
            int restTime = next.start - endTime;
            while(!stop.isEmpty() && restTime > 0) {
                Homework stopped = stop.peek();
                stopped.doing -= restTime;
                
                if(stopped.doing > 0) break;
                
                restTime = stopped.doing * -1;
                answer.add(stop.pop().name);
            }
        }
        
        answer.add(hw[plans.length - 1].name);
        while(!stop.isEmpty())
            answer.add(stop.pop().name);
        
        return answer.toArray(new String[answer.size()]);
    }
}