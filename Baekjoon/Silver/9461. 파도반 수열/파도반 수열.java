import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());        // TestCase 개수
        long[] dp = new long[101];                      // dp 배열 선언
        dp[1] = 1; dp[2] = 1; dp[3] = 1;                // 초깃값 설정

        for(int i = 4; i <= 100; i++)                   // i=4 일 경우 i=2, i=1일 때의 값을 더해주면 해당 값이 나옴
            dp[i] = dp[i-2] + dp[i-3];

        for(int i = 0; i < n; i++)                      // 입력받은 값을 인덱스로 넣어주어 해당 값을 StringBuilder에 저장
            stb.append(String.valueOf(dp[Integer.parseInt(br.readLine())]) + "\n");

        System.out.print(stb);                          // 값을 출력
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}