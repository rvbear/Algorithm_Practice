import java.io.*;

public class Main {
    static int mod = 1_000_000_009;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        dp = new long[100001];
        dp[0] = dp[1] = 1;                              // 초깃값 설정
        dp[2] = dp[3] = 2;
        dp[4] = dp[5] = 3;
        for(int i = 6; i <= 100_000; i++) {             // dp 점화식 : dp[i] = dp[i-6] + dp[i-4] + dp[i-2]
            dp[i] = (dp[i - 6] + dp[i - 4] + dp[i - 2]) % mod;
        }

        int n = Integer.parseInt(br.readLine());        // testcase 개수 입력
        for(int i = 0; i < n; i++) {                    // 개수만큼 반복하여 해당 결과값을 버퍼에 저장
            int testcase = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[testcase]) + "\n");
        }

        br.close();             // 입력 버퍼 스트림 닫아줌
        bw.close();             // 출력 버퍼 스트림 닫아줌
    }
}