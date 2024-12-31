import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());      // 카드의 개수
        int m = Integer.parseInt(stk.nextToken());      // 합체 횟수
        stk = new StringTokenizer(br.readLine());
        long[] card = new long[n];                      // 카드 저장 배열

        for(int i = 0; i < n; i++)
            card[i] = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < m; i++) {
            Arrays.sort(card);                          // 배열을 오름차순 정렬하고
            card[0] += card[1];                         // 가장 작은 두 값을 더한 뒤 그 값으로 치환
            card[1] = card[0];
        }

        long sum = 0;
        for(int i = 0; i < n; i++)                      // 모든 카드의 값을 더해줌
            sum += card[i];

        System.out.println(sum);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}