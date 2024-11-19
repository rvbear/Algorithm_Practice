import java.io.*;
import java.util.*;

public class Main {
    static int n, m, count = 0;                 // 컴퓨터의 수, 연결된 개수, 결과값
    static boolean[] visit;                     // 방문여부
    static boolean[][] map;                     // 연결망
    public static void bfs(int i) {             // 너비 우선 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int j = 1; j <= n; j++) {
                if(map[temp][j] && !visit[j]) {
                    queue.offer(j);
                    count++;
                    visit[j] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visit = new boolean[n+1];
        map = new boolean[n+1][n+1];
        for(int i = 0; i < m; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            map[a][b] = map[b][a] = true;
        }

        bfs(1);                   // bfs 탐색 시작
        System.out.println(count);  // 결과값 출력
        br.close();                 // 입력 버퍼 스트림 닫아줌
    }
}