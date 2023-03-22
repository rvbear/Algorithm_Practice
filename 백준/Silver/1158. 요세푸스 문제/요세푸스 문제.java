import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   // 버퍼 스트림을 통해 출력
        StringBuilder stb = new StringBuilder();                // StringBuilder를 통해 하나의 string으로 합쳐서 출력

        StringTokenizer stk = new StringTokenizer(br.readLine());       // StringTokenizer를 사용
        int N = Integer.parseInt(stk.nextToken());        // N값을 저장
        int K = Integer.parseInt(stk.nextToken());        // K값을 저장

        Queue<Integer> queue = new LinkedList<>();          // 큐 생성

        for(int i = 1; i <= N; i++)         // 큐에 저장
            queue.add(i);

        stb.append("<");        // 출력 형식을 맞춰줌
        for(int i = 0; i < N; i++) {        // N번 반복
            for(int j = 0; j < K-1; j++)        // (K-1)번째까지 queue에 다시 저장
                queue.add(queue.poll());
            stb.append(queue.poll());       // K번째를 StringBuilder에 저장
            if(i < N-1)                     // 출력 형식을 맞춰주기 위해 (N-2)번째까지만 ", "를 저장
                stb.append(", ");
        }
        stb.append(">");        // 출력 형식을 맞춰줌

        br.close();         // 입력 버퍼 스트림 닫아줌
        bw.write(String.valueOf(stb));      // StringBuilder에 저장된 값을 출력 버퍼 스트림으로 출력
        bw.close();         // 출력 버퍼 스트림 닫아줌
    }
}