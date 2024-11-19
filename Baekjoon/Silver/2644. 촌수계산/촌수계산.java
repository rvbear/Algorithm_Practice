import java.io.*;
import java.util.*;

public class Main {
    static int n, a, b, m;                                  // 총 인원, 탐색하려는 부모, 탐색하려는 자식, 관계의 수
    static boolean[] visit;                                 // 방문 여부
    static boolean[][] maps;                                // 그래프
    static Queue<Integer> queue = new LinkedList<>();       // bfs 탐색을 위한 queue
    static int bfs(int x, int y) {                          // bfs 탐색
        int count = 0;                                      // 촌수 계산
        queue.add(x);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                visit[cur] = true;
                if(cur == y) return count;
                for(int j = 1; j <= n; j++) {
                    if(maps[cur][j] && !visit[j]) {
                        queue.add(j);
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(br.readLine());

        maps = new boolean[n+1][n+1];
        visit = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            maps[x][y] = maps[y][x] = true;
        }

        System.out.println(bfs(a, b));      // bfs 탐색의 결과값 출력
        br.close();                         // 입력 버퍼 스트림 닫아줌
    }
}