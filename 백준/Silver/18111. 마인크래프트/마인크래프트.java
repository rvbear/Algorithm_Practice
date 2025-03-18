import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        int[][] map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHight = 0;

        for (int h = min; h <= max; h++) {
            int insCnt = 0;
            int delCnt = 0;
            int temp = b;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] < h) {
                        insCnt += h - map[i][j];
                        temp -= h - map[i][j];
                    } else if (map[i][j] > h) {
                        delCnt += 2 * (map[i][j] - h);
                        temp += map[i][j] - h;
                    }
                }
            }

            if (temp < 0) {
                continue;
            }

            int time = delCnt + insCnt;
            if (time <= minTime && h >= maxHight) {
                minTime = time;
                maxHight = h;
            }
        }
        
        System.out.println(minTime + " " + maxHight);
    }
}
