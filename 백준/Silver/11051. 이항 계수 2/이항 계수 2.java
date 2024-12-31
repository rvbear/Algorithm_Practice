import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 10007;
    static long[][] dp;
    static long BC(int n, int k) {                          // 재귀함수를 통해 팩토리얼 계산
        if(dp[n][k] > 0) return dp[n][k];                   // 이미 계산한 적 있는 값이라면 재사용
        if(k == 0 || n == k) return dp[n][k] = 1;           // 1이 나오는 경우
        return dp[n][k] = (BC(n-1, k-1) + BC(n-1, k)) % MOD;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        k = (n/2+1) < k ? n-k : k;              // 10C8 인 경우 10C2로 바꾸어 계산
        dp = new long[n+1][k+1];                // dp 배열 선언

        System.out.println(BC(n, k));           // 결과값 출력
        br.close();                             // 입력 버퍼 스트림 닫아줌
    }
}