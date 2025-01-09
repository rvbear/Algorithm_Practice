class Solution {
    int[][] point = {{0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1},
                     {4, 0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 5},
                     {3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4},
                     {4, 2, 1, 0, 3, 2, 1, 4, 3, 2, 5, 3},
                     {3, 1, 2, 3, 0, 1, 2, 1, 2, 3, 2, 4},
                     {2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3},
                     {3, 3, 2, 1, 2, 1, 0, 3, 2, 1, 4, 2},
                     {2, 2, 3, 4, 1, 2, 3, 0, 1, 2, 1, 3},
                     {1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2},
                     {2, 4, 3, 2, 3, 2, 1, 2, 1, 0, 3, 1},
                     {1, 3, 4, 5, 2, 3, 4, 1, 2, 3, 0, 2},
                     {1, 5, 4, 3, 4, 3, 2, 3, 2, 1, 2, 0}};
    
    public String solution(int[] numbers, String hand) {
        int leftNow = 10, rightNow = 11;
        StringBuilder answer = new StringBuilder("");
        
        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftNow = num;
                continue;
            }
            
            if(num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightNow = num;
                continue;
            }
            
            int cal = point[num][leftNow] - point[num][rightNow];
            
            if(cal != 0) {
                answer.append(cal > 0 ? "R" : "L");
                
                if(cal > 0) {
                    rightNow = num;
                } else {
                    leftNow = num;
                }
                
                continue;
            }
            
            if(hand.equals("right")) {
                answer.append("R");
                rightNow = num;
            } else {
                answer.append("L");
                leftNow = num;
            }
        }
        
        return answer.toString();
    }
}