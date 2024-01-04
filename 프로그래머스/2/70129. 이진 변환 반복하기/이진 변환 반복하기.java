class Solution {
    public int[] solution(String s) {
        int remove = 0, count = 0, temp = 0;
        
        while(!s.equals("1")) {
            count++;
            remove += (int) s.chars().filter(i -> String.valueOf((char)i).equals("0")).count();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
        }
        
        return new int[]{count, remove};
    }
}