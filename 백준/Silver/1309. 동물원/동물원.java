import java.io.*;

public class Main {
    static int mod = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        dp[0] = 1; dp[1] = 3;                           // 초깃값 설정

        for(int i = 2; i <= n; i++) {                   
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % mod;      // 점화식  
        }

        System.out.println(dp[n]);
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}