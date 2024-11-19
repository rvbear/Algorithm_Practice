class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String x = Long.toString(numbers[i], 2);
                int zeroIndex = x.lastIndexOf("0");
                String y = "";
                
                if(zeroIndex != -1) {
                    y = x.substring(0, zeroIndex) + "10" + x.substring(zeroIndex+2);
                } else {
                    y = "10" + x.substring(1);
                }
                
                answer[i] = Long.parseLong(y, 2);
            }
        }
        
        return answer;
    }
}