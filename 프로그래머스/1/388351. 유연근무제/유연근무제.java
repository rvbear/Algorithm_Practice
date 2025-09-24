class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            int day = startday;
            boolean flag = true;

            for (int j = 0; j < 7; j++) {
                int currentDay = (day + j) % 7;
                if (currentDay == 0 || currentDay == 6) {
                    continue;
                }

                int timeOut = schedules[i] % 100 + 10 >= 60 ? schedules[i] + 50 : schedules[i] + 10;

                if (timeOut < timelogs[i][j]) {
                    flag = false;
                    break;
                }
            }

            answer += flag ? 1 : 0;
        }

        return answer;
    }
}
