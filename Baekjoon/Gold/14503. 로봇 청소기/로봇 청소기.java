import java.io.*;
import java.util.*;

public class Main {
    static int n, m, count = 1;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0};        // 북, 동, 남, 서 순서대로
    static int[] dy = {0, 1, 0, -1};        // 북, 동, 남, 서 순서대로
    public static void dfs(int x, int y, int d) {
        room[x][y] = -1;                    // 청소를 진행

        for(int i = 0; i < 4; i++) {
            d = (d + 3) % 4;                // 왼쪽 방향으로 전환 북->동->남->서 순서대로
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 청소가 안된 곳이 있다면 count 증가 후 dfs 재귀
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] == 0) {
                count++;
                dfs(nx, ny, d);
                return;     // 종료해주지 않으면 복귀하는 과정에서 뒤로 가는 오류 발생
            }
        }

        // 네 방향을 모두 살펴봤을 때 이미 청소가 되어있거나, 벽인 경우
        // 바라보는 방향을 유지한 채 후진
        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if(bx >= 0 && bx < n && by >= 0 && by < m && room[bx][by] != 1) {
            dfs(bx, by, d);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());      // 방의 크기 n
        m = Integer.parseInt(stk.nextToken());      // 방의 크기 m
        stk = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stk.nextToken());      // 청소기 시작 x 좌표
        int c = Integer.parseInt(stk.nextToken());      // 청소기 시작 y 좌표
        int d = Integer.parseInt(stk.nextToken());      // 청소기 시작 방향 = 0 : 북, 1 : 동, 2 : 남, 3 : 서

        room = new int[n][m];
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);
        br.close();
    }
}