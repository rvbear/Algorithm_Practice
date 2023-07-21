import java.io.*;
import java.util.*;

public class Main {
    static int n, m;                            // 가로, 세로
    static int[] dx = {-1, 1, 0, 0};            // 움직이는 x 좌표
    static int[] dy = {0, 0, -1, 1};            // 움직이는 y 좌표
    static int[][] map;                         // 토마토 박스의 정보를 저장할 배열
    static Queue<int[]> queue = new LinkedList<>();
    public static void bfs() {                  // 너비 우선 탐색
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                // mx, my가 박스의 크기를 벗어나지 않으며 익지 않은 토마토가 있을 경우
                if(mx >= 0 && mx < m && my >= 0 && my < n && map[mx][my] == 0) {
                    queue.offer(new int[]{mx, my});
                    map[mx][my] = map[x][y] + 1;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[m][n];

        for(int i = 0; i < m; i++) {                    // 토마토 박스의 정보를 저장
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 1) {
                    queue.offer(new int[]{i, j});       // 익은 토마토의 위치를 저장
                }
            }
        }

        bfs();                                          // 너비 우선 탐색 시작

        int result = 0;                                 // 최대 걸리는 일수
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);             // 모든 토마토가 익지 않은 경우
                    return;
                }
                result = Math.max(result, map[i][j]);   
            }
        }

        System.out.println(result - 1);                 // 최대 일수 - 1을 해줘야함
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}