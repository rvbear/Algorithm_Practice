import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];               // 입력값 저장 배열
        int[] dp = new int[n+1];                // dp
        int max = Integer.MIN_VALUE;            // 최댓값 저장 변수

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(stk.nextToken());     // 입력값 넣어줌
            dp[i] = 1;                                      // dp값 초기화

            for(int j = 1; j < i; j++) {                    // 내가 입력한 값이 이전에 있던 값들보다 클 경우 dp값을 비교하여 저장
                if(num[i] > num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);                     // 가장 큰 값을 비교하여 저장
        }

        System.out.println(max);    // 결과값 출력
        br.close();                 // 입력 버퍼 스트림 닫아줌
    }
}