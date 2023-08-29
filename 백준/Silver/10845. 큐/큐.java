import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());        // 테스트 케이스 개수
        Deque<Integer> q = new LinkedList<>();          // Deque 선언

        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String order = stk.nextToken();
            if(order.equals("push")) {                  // push 명령을 입력 받을 경우
                q.push(Integer.parseInt(stk.nextToken()));
            } else if(order.equals("pop")) {            // pop 명령을 입력 받을 경우
                stb.append(!q.isEmpty() ? q.pollLast() : -1).append("\n");
            } else if(order.equals("size")) {           // size 명령을 입력 받을 경우
                stb.append(q.size()).append("\n");
            } else if(order.equals("empty")) {          // empty 명령을 입력 받을 경우
                stb.append(!q.isEmpty() ? 0 : 1).append("\n");
            } else if(order.equals("front")) {          // front 명령을 입력 받을 경우
                stb.append(!q.isEmpty() ? q.peekLast() : -1).append("\n");
            } else {                                    // back 명령을 입력 받을 경우
                stb.append(!q.isEmpty() ? q.peekFirst() : -1).append("\n");
            }
        }

        System.out.print(stb);                          // 결과값 출력
        br.close();
    }
}