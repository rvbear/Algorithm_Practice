import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        long[] dp = new long[1101];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(input[i - 1]);
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] >= Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j <= num[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        System.out.println(dp[n] >= Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
