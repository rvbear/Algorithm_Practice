import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());              // 병사의 수
        stk = new StringTokenizer(br.readLine());
        int[] power = new int[N+1];                           // 전투력 저장 배열
        int[] DP = new int[N+1];                              // DP 저장 배열

        for(int i = N; i > 0; i--) {                          // 전투력을 입력받아 거꾸로 저장
            power[i] = Integer.parseInt(stk.nextToken());
            DP[i] = 1;                                        // 초깃값 1로 설정
        }

        for(int i = 2; i <= N; i++)
            for(int j = 1; j < i; j++)                        // i보다 작은 인덱스의 값을 모두 비교
                // ex) 12 2 5 4 일 경우 power에는 4 5 2 12로 저장, DP의 값은 1 2 2 3
                if (power[j] < power[i])
                    DP[i] = Math.max(DP[i], DP[j] + 1);

        int max = DP[0];
        for(int i = 1; i <= N; i++)
            max = Math.max(max, DP[i]);     // 예시대로 가면 max = 3

        System.out.println(N-max);          // N에서 max 값을 빼주면 최소 예외인원이 나옴
        br.close();                         // 입력 버퍼 스트림 닫아줌
    }
}