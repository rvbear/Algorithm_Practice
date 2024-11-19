import java.io.*;

public class Main {
    static int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 자리수 입력
        long[][] DP = new long[N+1][10];                    // DP 배열 선언
        for(int i = 0; i < 10; i++) DP[0][i] = 1;           // 초깃값 선언

        for(int i = 1; i <= N; i++)
            for(int j = 0; j < 10; j++)
                for(int k = j; k < 10; k++) {               // 이전 DP 배열의 j부터 9까지의 합
                    DP[i][j] += DP[i-1][k];
                    DP[i][j] %= MOD;
                }

        System.out.println(DP[N][0] % MOD);                 // 결과값 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}