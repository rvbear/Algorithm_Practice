import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());      // 남은 기간
        int M = Integer.parseInt(stk.nextToken());      // 챕터의 수

        int[] day = new int[M];                         // 챕터별 읽는 데 걸리는 시간
        int[] pages = new int[M];                       // 챕터별 페이지 수
        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(stk.nextToken()); 
            pages[i] = Integer.parseInt(stk.nextToken());
        }

        int[] DP = new int[N+1];                        // DP 배열 생성
        for(int i = 0; i < M; i++)
            for(int j = N; j >= day[i]; j--)            // 해당 기간 동안 읽을 수 있는 최댓값 구하기
                DP[j] = Math.max(DP[j], DP[j-day[i]] + pages[i]);

        System.out.println(DP[N]);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}