import java.util.*;

class Solution {
    long changeMilSec(String time) {
        long val = 0;
        String[] s = time.split(":");
        val += Long.parseLong(s[0]) * 60 * 60;
        val += Long.parseLong(s[1]) * 60;
        val *= 1000;
        val += Double.parseDouble(s[2]) * 1000; 
        
        return val;
    }
    
    public int solution(String[] lines) {
        List<long[]> list = new ArrayList<>();
        for(String line : lines) {
            String[] s = line.split(" ");
            long end = changeMilSec(s[1]);
            long start = end - (long)(Double.parseDouble(s[2].replace("s", "")) * 1000) + 1;
            list.add(new long[]{start, end});
        }
        
        int ans = 0;
        for(int i = 0; i < list.size(); i++) {
            int cnt = 0;
            long end = list.get(i)[1];
            for(long[] job : list) {
                if(job[0] < end + 1000 && job[1] >= end) {
                    cnt++;
                }
            }
            
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
}