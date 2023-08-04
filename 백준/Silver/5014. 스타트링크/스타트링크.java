import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;                               // 입력 받아야하는 값
    static int[] visit;                                     // 탐색을 위한 배열
    public static void bfs() {                              // 탐색 시작
        Queue<Integer> queue = new LinkedList<>();          // queue 생성
        queue.add(s);
        visit[s] = 1;

        while(!queue.isEmpty()) {                           // queue에 값이 없을 때 종료
            int temp = queue.poll();

            if(temp == g) {                                 // 현재 위치에 도착했을 경우 출력
                System.out.println(visit[temp] - 1);
            }
            if(temp + u <= f && visit[temp + u] == 0) {     // 올라갈 수 있을 때
                visit[temp + u] = visit[temp] + 1;
                queue.add(temp + u);
            }
            if(temp - d > 0 && visit[temp - d] == 0) {      // 내려갈 수 있을 때
                visit[temp - d] = visit[temp] + 1;
                queue.add(temp - d);
            }
        }

        if(visit[g] == 0) {                                 // 도착할 수 없을 때
            System.out.println("use the stairs");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        f = Integer.parseInt(stk.nextToken());              // 총 층수
        s = Integer.parseInt(stk.nextToken());              // 현재 층수
        g = Integer.parseInt(stk.nextToken());              // 가야하는 층수
        u = Integer.parseInt(stk.nextToken());              // 한번에 올라가는 층수
        d = Integer.parseInt(stk.nextToken());              // 한번에 내려가는 층수

        visit = new int[f+1];                               // 탐색을 위한 배열 생성

        bfs();                                              // 탐색 시작
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}