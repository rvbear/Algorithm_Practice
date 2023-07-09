import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringBuilder sb = new StringBuilder();                                         // 결과 저장을 위한 StringBuilder
        StringTokenizer stk;

        int[][] dp = new int[30][30];

        for(int i = 0; i < 30; i++) {                                                   // nCn, nC1 = 1을 저장
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for(int i = 2; i < 30; i++)                                                     // ex) 3C2 = 2C1 + 2C2
            for(int j = 1; j < 30; j++)
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());                                  // 강 서쪽 사이트 개수
            int m = Integer.parseInt(stk.nextToken());                                  // 강 동쪽 사이트 개수
            sb.append(dp[m][n]).append("\n");                                           // StringBuilder에 결과 저장
        }

        System.out.print(sb);                                                           // 결과 출력
        br.close();                                                                     // 입력 버퍼 스트림 닫아줌
    }
}