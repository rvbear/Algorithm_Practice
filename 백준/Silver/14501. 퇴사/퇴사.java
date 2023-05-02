import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());            // Test case 개수
        int[] T = new int[N];
        int[] P = new int[N];
        int[] DP = new int[N+1];

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(stk.nextToken());     // 상담시간
            P[i] = Integer.parseInt(stk.nextToken());     // 수익
        }

        for(int i = N-1; i >= 0; i--) {
            int period = i + T[i];                        // 상담기간

            if(period <= N)                               // 상담이 가능할 경우
                DP[i] = Math.max(P[i] + DP[period], DP[i+1]);
            else                                          // 상담이 불가능할 경우
                DP[i] = DP[i+1];
        }

        System.out.println(DP[0]);                        // 최댓값 출력
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}