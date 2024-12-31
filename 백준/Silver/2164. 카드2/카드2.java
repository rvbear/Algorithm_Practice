import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        
        int N = Integer.parseInt(br.readLine());        // 정수 N 입력

        Queue<Integer> queue = new LinkedList<>();      // 카드를 입력할 큐 선언

        for(int i = 1; i <= N; i++)                     // 큐에 값을 넣어줌
            queue.add(i);

        for(int i = 1; queue.size() > 1; i++) {         // 큐의 크기가 1이 될 때까지 진행
            if(i % 2 == 1)                              // 홀수번째 진행이라면 큐에서 제거
                queue.poll();
            else                                        // 짝수번째 진행이라면 맨 첫번째 값을 맨 뒤로 저장
                queue.add(queue.poll());
        }

        bw.write(String.valueOf(queue.poll()));           // 큐에 남은 값을 출력
        bw.close();     // 출력 버퍼 스트림 닫아줌
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}
