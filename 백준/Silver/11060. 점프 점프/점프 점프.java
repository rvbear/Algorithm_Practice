import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int n = Integer.parseInt(br.readLine());        // 입력 개수
        int[] num = new int[n+1]; long[] dp = new long[1101];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {                   // 초기화
            num[i] = Integer.parseInt(stk.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;                                      // 초깃값 설정
        for(int i = 1; i <= n; i++) {                   // dp를 통해 최솟값 구하기
            if(dp[i] >= Integer.MAX_VALUE) continue;
            for (int j = 1; j <= num[i]; j++)
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
        }

        if(dp[n] >= Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}