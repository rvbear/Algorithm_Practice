import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static int[][] move = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    static boolean[][][] visit;

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1, 0});
        visit[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int count = arr[2];
            int pass = arr[3];

            if(x == n-1 && y == m-1) {
                return count;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(map[nx][ny] == 0 && !visit[nx][ny][pass]) {
                    q.add(new int[] {nx, ny, count+1, pass});
                    visit[nx][ny][pass] = true;
                } else {
                    if(pass < k && !visit[nx][ny][pass+1]) {
                        q.add(new int[] {nx, ny, count+1, pass+1});
                        visit[nx][ny][pass+1] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        map = new int[n][m];
        visit = new boolean[n][m][k+1];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
        br.close();
    }
}