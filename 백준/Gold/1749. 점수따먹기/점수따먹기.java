import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                for(int k = i; k <= n; k++) {
                    for(int l = j; l <= m; l++) {
                        max = Math.max(max, dp[k][l] - dp[i-1][l] - dp[k][j-1] + dp[i-1][j-1]);
                    }
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}