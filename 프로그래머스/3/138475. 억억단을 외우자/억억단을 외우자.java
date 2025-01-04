import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[][] dp = new int[e+1][2];
        
        for(int i = 0; i < e+1; i++) {
            dp[i][0] = i;
        }
        
        for(int i = 1; i < e+1; i++) {
            for(int j = i; j < e+1; j += i) {
                dp[j][1]++;
            }
        }
        
        Arrays.sort(dp, new Comparator<int[]>() {
           @Override
            public int compare(int[] a, int[] b) {
                if(a[1] < b[1]) {
                    return 1;
                } else if(a[1] > b[1]) {
                    return -1;
                } else {
                    if(a[0] > b[0]) {
                        return 1;
                    } else if(a[0] < b[0]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        
        int[] answer = new int[starts.length];
        for(int i = 0; i < starts.length; i++) {
            for(int j = 0; j < e+1; j++) {
                if(starts[i] <= dp[j][0]) {
                    answer[i] = dp[j][0];
                    break;
                }
            }
        }
        
        return answer;
    }
}