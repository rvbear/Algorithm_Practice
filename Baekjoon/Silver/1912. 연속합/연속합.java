import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 입력값의 개수
        int[] numbers = new int[N+1];                       // 입력값 저장 배열
        int[] DP = new int[N+1];                            // DP 배열

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)                         // 값 입력
            numbers[i] = Integer.parseInt(stk.nextToken());

        DP[1] = numbers[1];                                 // 초깃값 설정
        int max = DP[1];
        for(int i = 2; i <= N; i++) {                       // 연속된 값과 현재 값 비교
            DP[i] = Math.max(DP[i-1] + numbers[i], numbers[i]);
            max = Math.max(max, DP[i]);
        }

        System.out.println(max);                            // 최종 결과값 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}