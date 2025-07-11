import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        int x = 0, y = 0;
        loop:
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (map[i][j] == '*') {
                    if (map[i - 1][j] == '*' && map[i + 1][j] == '*' && map[i][j - 1] == '*' && map[i][j + 1] == '*') {
                        stb.append(i).append(" ").append(j).append("\n");
                        x = i;
                        y = j;
                        break loop;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = y - 1; i > 0; i--) {
            if (map[x][i] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        stb.append(cnt).append(" ");

        cnt = 0;
        for (int i = y + 1; i < n + 1; i++) {
            if (map[x][i] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        stb.append(cnt).append(" ");

        cnt = 0;
        for (int i = x + 1; i < n + 1; i++) {
            if (map[i][y] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        stb.append(cnt).append(" ");
        x += cnt;

        cnt = 0;
        for (int i = x + 1; i < n + 1; i++) {
            if (map[i][y - 1] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        stb.append(cnt).append(" ");

        cnt = 0;
        for (int i = x + 1; i < n + 1; i++) {
            if (map[i][y + 1] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        stb.append(cnt).append(" ");

        System.out.print(stb);
    }
}
