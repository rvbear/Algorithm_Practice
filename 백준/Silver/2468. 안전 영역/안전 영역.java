import java.io.*;
import java.util.*;

public class Main {
    static int n, max = 0;                              // 지역의 크기, 안전지대 개수
    static ArrayList<Integer> list = new ArrayList<>(); // 비의 양을 저장할 배열
    static int[] dx = {-1, 1, 0, 0};                    // 움직이는 x 좌표
    static int[] dy = {0, 0, -1, 1};                    // 움직이는 y 좌표
    static int[][] map;                                 // 지역의 정보 저장
    static boolean[][] visit;                           // 방문여부
    public static void dfs(int x, int y, int num) {     // dfs 탐색 시작
        visit[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny] && map[nx][ny] >= num) {
                dfs(nx, ny, num);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(!list.contains(map[i][j])) {
                    list.add(map[i][j]);
                }
            }
        }

        for(int num : list) {                               // 안전지대의 개수가 가장 많음을 비교해야하기 때문에 잠기는 높이를 반복문으로 비교
            visit = new boolean[n][n];                      // 비교할 때마다 방문여부 배열 초기화
            int count = 0;                                  // 안전지대 개수 초기화

            for(int i = 0; i < n; i++) {                    // 탐색 시작
                for(int j = 0; j < n; j++) {
                    if(!visit[i][j] && map[i][j] >= num) {
                        dfs(i, j, num);
                        count++;
                    }
                }
            }

            max = Math.max(count, max);                     // 안전지대의 개수 비교
        }

        System.out.println(max);                            // 가장 많은 안전지대의 개수 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}