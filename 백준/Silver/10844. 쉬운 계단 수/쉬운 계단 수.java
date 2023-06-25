import java.io.*;

public class Main {
    static long[][] DP;
    static long MOD = 1_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 자릿수 입력
        DP = new long[N+1][10];                         // DP 배열 생성

        for(int i = 0; i <= 9; i++) DP[1][i] = 1L;      // 초깃값 설정
        
        for(int i = 2; i <= N; i++) {
            DP[i][0] = DP[i-1][1];                      // 0으로 시작하는 값은 이전에 1로 시작하는 값과 동일
            for(int j = 1; j <= 9; j++) {               // 9를 제외한 나머지는 j-1, j+1로 시작하는 값을 더해야함
                if(j == 9) DP[i][9] = DP[i-1][8] % MOD;
                else DP[i][j] = ((DP[i-1][j-1] % MOD) + (DP[i-1][j+1] % MOD)) % MOD;
            }
        }

        long result = 0;
        for(int i = 1; i <= 9; i++)                     // 오버플로우 발생을 막기 위해 % 연산을 더할 때마다 진행
            result = (result + DP[N][i]) % MOD;

        System.out.println(result);                     // 결과값 출력
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}