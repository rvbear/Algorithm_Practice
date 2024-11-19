import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());                    // 카드 묶음의 수를 입력

        PriorityQueue<Long> queue = new PriorityQueue<>();          // 우선순위 큐

        for(int i = 0; i < N; i++)                                  // N번 반복
            queue.add(Long.decode(br.readLine()));                  // queue에 값을 저장

        long count = 0;                                             // 최소 비교 횟수
        while(queue.size() > 1) {                                   // queue의 크기가 1보다 커야 비교 가능
            long temp1 = queue.poll();
            long temp2 = queue.poll();

            count += temp1 + temp2;
            queue.add(temp1 + temp2);                               // 합한 묶음 다시 넣기
        }

        System.out.println(count);

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}