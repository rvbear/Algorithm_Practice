import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N+1];                             // 수열을 저장할 배열
        long[] DP = new long[N+1];                                  // DP 배열
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {                               // 수열의 값을 저장
            numbers[i] = Long.parseLong(stk.nextToken());
            DP[i] = 1;                                              // 초깃값 설정
        }

        long max = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++)
                if(numbers[i] > numbers[j])                         // 이전 값들 중 가장 큰 DP값 + 1
                    DP[i] = Math.max(DP[i], DP[j]+1);
            max = Math.max(max, DP[i]);                             // LIS 길이 구하기
        }

        System.out.println(max);                                    // 결과값 출력
        br.close();                                                 // 입력 버퍼 스트림 닫아줌
    }
}