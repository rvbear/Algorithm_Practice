import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int res = Integer.MAX_VALUE;
    static void back(int start, int now, int cost, int count) {
        if (map[now][start] != 0 && count == n) {
            res = Math.min(res, cost+ map[now][start]);
            return;
        }

        for (int i = 0; i < n; i++){
            if (map[now][i] > 0 && !visit[i]) {
                visit[i] = true;
                back(start, i,cost + map[now][i], count+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit[0] = true;
        back(0,0,0,1);
        System.out.println(res);
    }
}
