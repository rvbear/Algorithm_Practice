import java.io.*;

public class Main {
    static long MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));         // 버퍼 스트림을 통해 출력

        int N = Integer.parseInt(br.readLine());            // case 개수
        long[] DP = new long[1000001];                      // DP 배열

        DP[1] = 1; DP[2] = 2; DP[3] = 4;                    // 초깃값 선언
        for (int i = 4; i <= 1000000; i++)                  // 해당 값 i의 i-1, i-2, i-3의 값을 더해줌
            DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3]) % MOD;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());      // case 입력
            bw.write(String.valueOf(DP[num]) + "\n");
        }

        br.close();                                         // 입력 버퍼 스트림 닫아줌
        bw.close();                                         // 출력 버퍼 스트림 닫아줌
    }
}