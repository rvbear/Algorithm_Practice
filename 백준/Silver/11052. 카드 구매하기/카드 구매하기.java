import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N+1];                                     // 카드별 가격
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            P[i] = Integer.parseInt(stk.nextToken());

        int[] DP = new int[N+1];                                    // DP
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= i; j++)
                DP[i] = Math.max(DP[i], DP[i-j] + P[j]);

        System.out.println(DP[N]);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}