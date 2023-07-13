import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        int n = Integer.parseInt(br.readLine());            // 좌석의 개수
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;                               // dp 초깃값 설정
        for(int i = 2; i <= n; i++)                         // 점화식 : dp[i] = dp[i-1] + dp[i-2]
            dp[i] = dp[i-1] + dp[i-2];

        int m = Integer.parseInt(br.readLine());            // 고정석 개수
        int result = 1; int temp = 0; int before = 0;       // 결과값, 고정석, 이전 고정석
        for(int i = 0; i < m; i++) {                        // 고정석을 입력 받고 (이전 고정석 + 1)을 뺸 값은 dp 인덱스로 넣어줌
            temp = Integer.parseInt(br.readLine());
            result *= dp[temp - before - 1];
            before = temp;                                  // 이전 고정석의 값을 변경
        }
        result *= dp[n - before];                           // 마지막 고정석 이후의 값을 곱해줌

        System.out.println(result);                         // 결과값 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}