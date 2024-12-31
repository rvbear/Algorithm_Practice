import java.io.*;
import java.util.*;

public class Main {
    static int n, m;                                // 행, 열
    static int[] dx = {-1, 1 ,0, 0};                // 움직이는 x 좌표
    static int[] dy = {0, 0, -1, 1};                // 움직이는 y 좌표
    static int[][] map;                             // 미로
    static boolean[][] visit;                       // 방문여부
    public static void bfs(int x, int y) {          // 너비 우선 탐색(bfs) 시작
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for(int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                if(mx >= 0 && mx < n && my >= 0 && my < m && !visit[mx][my] && map[mx][my] == 1) {
                    queue.offer(new int[]{mx, my});
                    visit[mx][my] = true;
                    map[mx][my] = map[nx][ny] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());          // 행 입력
        m = Integer.parseInt(stk.nextToken());          // 열 입력

        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++) {                    // 미로의 정보 입력
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visit[0][0] = true;
        bfs(0, 0);                                // 탐색 시작
        System.out.println(map[n-1][m-1]);              // 결과값 출력  
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}