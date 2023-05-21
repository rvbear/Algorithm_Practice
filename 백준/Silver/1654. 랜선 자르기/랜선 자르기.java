import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(stk.nextToken());          // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(stk.nextToken());          // 필요한 랜선의 개수
        long[] lines = new long[K];                         // 랜선의 길이를 저장할 배열
        long max = 0;                                       // 가장 긴 랜선의 길이

        for(int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            if(max < lines[i]) max = lines[i];
        }

        long min = 1, mid = 0, count;                       // 최솟값 = 1로 설정, 중간값, count 개수 선언

        while(min <= max) {
            count = 0;                                      // count 초깃값 설정

            mid = (max + min) / 2;                          // 중간값 설정
            for(int i = 0; i < K; i++)                      // 중간값을 통해 나오는 랜선의 개수를 count에 저장
                count += lines[i] / mid;

            if(count < N) max = mid - 1;                    // count가 N보다 작을 경우 더 줄여야함
            else min = mid + 1;                             // count가 N보다 클 경우 더 늘릴 수 있음
        }

        System.out.println((max + min) / 2);                // 잘라야하는 랜선의 길이
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}