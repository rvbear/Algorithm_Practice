import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n+1];                                     // 수열을 저장할 배열
        long[] dp = new long[n+1];                                      // dp 배열

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)                                     // 수열을 저장
            num[i] = Long.parseLong(stk.nextToken());

        long max = 1;                                                   // max값 선언
        for(int i = 1; i <= n; i++) {
            dp[i] = num[i];                                             // 초깃값 설정
            for (int j = 1; j < i; j++)                                 // 해당 위치에서 만들 수 있는 수열의 크기를 저장
                if (num[i] > num[j])
                    dp[i] = Math.max(dp[j] + num[i], dp[i]);
            max = Math.max(max, dp[i]);                                 // max 값과 비교하여 큰 값을 max 값에 저장
        }

        System.out.println(max);                                        // 결과값 출력
        br.close();                                                     // 입력 버퍼 스트림 닫아줌
    }
}