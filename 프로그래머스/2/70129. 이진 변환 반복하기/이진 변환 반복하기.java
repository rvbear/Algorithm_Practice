class Solution {
    public int[] solution(String s) {
        int remove = 0, count = 0, temp = 0;
        
        while(!s.equals("1")) {
            count++;
            int before = s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            remove += before - temp;
            s = Integer.toBinaryString(temp);
        }
        
        return new int[]{count, remove};
    }
}