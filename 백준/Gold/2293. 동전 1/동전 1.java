import java.io.*;
import java.util.*;

public class Main {
    static int[] dp, coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());              // 동전 종류의 개수
        int k = Integer.parseInt(stk.nextToken());              // 가치의 합

        coins = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;                                              // 초깃값 설정

        for(int i = 1; i <= n; i++) {                           // dp[i] = dp[i-coins[i]] + dp[i]
            coins[i] = Integer.parseInt(br.readLine());
            for(int j = coins[i]; j <= k; j++)
                dp[j] += dp[j-coins[i]];
        }

        System.out.println(dp[k]);                              // 결과값 출력
        br.close();                                             // 입력 버퍼 스트림 닫아줌
    }
}