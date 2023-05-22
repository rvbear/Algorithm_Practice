import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());            // 지방의 수
        int[] request = new int[N];                         // 지방별 예산 요청 금액
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            request[i] = Integer.parseInt(stk.nextToken());
        long M = Long.parseLong(br.readLine());             // 총 예산

        Arrays.sort(request);                               // 배열 오름차순 정렬
        long min = 0, max = request[N-1], mid = 0, sum = 0; // 최솟값, 최댓값, 중간값, 총합 설정
        while(min <= max) {                                 // 이분탐색
            mid = (min + max) / 2;                          // 중간 값을 구하고

            for(int money : request) {                      // 각 조건에 맞게 더하여 총합을 구한 뒤
                if(mid < money) sum += mid;
                else sum+= money;
            }

            if(sum > M) max = mid - 1;                      // 그 합이 M보다 크다면 최댓값을
            else min = mid + 1;                             // M보다 작거나 같다면 최솟값을 변경

            sum = 0;
        }

        System.out.println((min+max)/2);                    // 최종값을 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}