import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static int N, core, answer, count;
    private static int[][] map;
    private static ArrayList<int[]> list;
    private final static int[] dx = {0, 0, -1, 1};
    private final static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
            list = new ArrayList<>();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();

                    if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        list.add(new int[] {i, j});
                    }
                }
            }

            core = 0;
            answer = 144;

            dfs(0, 0, 0);

            System.out.println("#" + testCase + " " + answer);
        }
    }

    private static void dfs(int c, int line, int depth) {
        if (depth == list.size()) {
            if (core < c) {
                core = c;
                answer = line;
            } else if (core == c) {
                answer = Math.min(answer, line);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (isConnect(list.get(depth), i)) {
                fill(list.get(depth), i, 2);
                dfs(c + 1, line + count, depth + 1);
                fill(list.get(depth), i, 0);
            }
        }

        dfs(c, line, depth + 1);
    }

    private static void fill(int[] index, int dir, int value) {
        count = 0;

        int x = index[0] + dx[dir];
        int y = index[1] + dy[dir];

        while (x >= 0 && y >= 0 && x < N && y < N) {
            map[x][y] = value;
            count++;
            x = x + dx[dir];
            y = y + dy[dir];
        }
    }

    private static boolean isConnect(int[] index, int dir) {
        int x = index[0] + dx[dir];
        int y = index[1] + dy[dir];

        while (x >= 0 && y >= 0 && x < N && y < N) {
            if (map[x][y] != 0) {
                return false;
            }

            x = x + dx[dir];
            y = y + dy[dir];
        }

        return true;
    }
}
