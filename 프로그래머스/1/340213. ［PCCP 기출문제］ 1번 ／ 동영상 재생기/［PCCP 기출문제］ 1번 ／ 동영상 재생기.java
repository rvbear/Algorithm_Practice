class Solution {
    public int checkOpTime(int posTime, int opStartTime, int opEndTime) {
        if(posTime >= opStartTime && posTime <= opEndTime) {
            return opEndTime;
        }
        
        return posTime;
    }
    public String solution(String videoLen, String pos, String opStart, String opEnd, String[] commands) {
        String[] temp = videoLen.split(":");
        int allTime = 60 * Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
        temp = pos.split(":");
        int posTime = 60 * Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
        temp = opStart.split(":");
        int opStartTime = 60 * Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
        temp = opEnd.split(":");
        int opEndTime = 60 * Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
        
        posTime = checkOpTime(posTime, opStartTime, opEndTime);
        
        for(String command : commands) {
            if(command.equals("prev")) {
                posTime = posTime - 10 < 0 ? 0 : posTime - 10;
            } else {
                posTime = posTime + 10 < allTime ? posTime + 10 : allTime;
            }
            
            posTime = checkOpTime(posTime, opStartTime, opEndTime);
        }
        
        int min = posTime / 60;
        int sec = posTime % 60;
        
        String answer = "";
        answer += min < 10 ? "0" + min : min;
        answer += ":";
        answer += sec < 10 ? "0" + sec : sec;
        
        return answer;
    }
}