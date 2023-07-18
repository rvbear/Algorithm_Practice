import java.io.*;

public class Main {
    static long mod = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        long[] dp = new long[50001];                    // dp 배열
        dp[1] = dp[2] = 1;                              // dp 초깃값 설정
        dp[3] = 2;                                      // dp 초깃값 설정
        for(int i = 4; i <= 50000; i++) {               // 점화식 : dp[i] = dp[i-3] + dp[i-1]
            dp[i] = (dp[i-3] + dp[i-1]) % mod;
        }

        System.out.println(dp[Integer.parseInt(br.readLine())]);        // 결과값 출력
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}