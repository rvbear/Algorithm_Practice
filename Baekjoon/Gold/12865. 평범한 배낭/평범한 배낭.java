import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());      // 물품의 수
        int k = Integer.parseInt(stk.nextToken());      // 버틸 수 있는 무게
        int[] w = new int[n+1];                         // 각 물건의 무게
        int[] v = new int[n+1];                         // 해당 물건의 가치
        int[] dp = new int[k+1];

        for(int i = 1; i <= n; i++) {                   // 해당 값들 입력
            stk = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(stk.nextToken());
            v[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= n; i++)                     // 최대 무게가 될 때까지 값을 비교
            for(int j = k; j - w[i] >= 0; j--)
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);

        System.out.println(dp[k]);
        br.close();                 // 입력 버퍼 스트림 닫아줌
    }
}