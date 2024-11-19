import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // BOJ 캠프 참가자 수

        Queue<Integer> queue = new LinkedList<>();      // 값을 저장할 큐 선언
        for(int i = 1; i <= N; i++)                     // 큐에 값을 넣어줌
            queue.add(i);

        for(int i = 1; i < N; i++) {
            long count = (long)Math.pow(i, 3);            // 각 단계별 3제곱의 값을 구함
            // 나머지 연산자를 사용
            for(int j = 1; j < ((count % queue.size() == 0) ? queue.size() : count % queue.size()); j++)
                queue.add(queue.remove());
            queue.remove();                             // 해당 숫자를 외친 사람을 큐에서 제거
        }

        System.out.println(queue.remove());             // 가장 마지막에 남은 사람을 출력
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}