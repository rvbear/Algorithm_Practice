import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(stk.nextToken());          // 지구를 나타내는 수 (1 <= E <= 15)
        int S = Integer.parseInt(stk.nextToken());          // 태양을 나타내는 수 (1 <= S <= 28)
        int M = Integer.parseInt(stk.nextToken());          // 달을 나타내는 수 (1 <= M <= 19)

        int count = 0;                                      // 년도 계산
        // 해당 년도를 계산하기 위해 for문에 조건을 여러 개를 사용
        for(int i = 1, j = 1, k = 1; i <= 15 && j <= 28 && k <= 19; i++, j++, k++) {
            count++;                                        // 년도 증가
            if(i == E && j == S && k == M) break;           // 값이 같다면 break;
            if(i == 15) i = 0; if(j == 28) j = 0; if(k == 19) k = 0;        // 해당 범위가 지나가면 초기화
        }

        System.out.println(count);      // 계산한 년도 출력
        br.close();                     // 입력 버퍼 스트림 닫아줌
    }
}