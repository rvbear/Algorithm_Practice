import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        Integer N = Integer.parseInt(br.readLine());        // 자릿수 입력
        long[] DP = new long[N + 1];

        DP[1] = 1;
        for(int i = 2; i <= N; i++)                     // 이친수의 개수는 피보나치 수열
            DP[i] = DP[i - 2] + DP[i - 1];

        System.out.println(DP[N]);                      // 원하는 값 출력
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}