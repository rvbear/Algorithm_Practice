import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(stk.nextToken());      // 값의 개수
        int K = Integer.parseInt(stk.nextToken());      // 순열의 값

        Queue<Integer> queue = new LinkedList<>();      // 큐 선언
        for(int i = 1; i <= N; i++)                     // 큐 안에 값을 넣어줌
            queue.add(i);

        stb.append("<");
        for(int i = 0; queue.size() > 0; i++) {         // 큐의 사이즈가 0이 될 때까지 반복
            for(int j = 0; j < K - 1; j++)              // 해당 순열의 숫자 전까지 큐에서 빼낸 뒤 다시 저장
                queue.add(queue.poll());
            stb.append(queue.poll());                   // 해당 숫자를 StringBuilder에 저장
            if(queue.size() > 0)
                stb.append(", ");
        }
        stb.append(">");

        System.out.println(stb);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}