import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][5];

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(input[0]);
            map[i][1] = Integer.parseInt(input[1]);
            map[i][2] = Integer.parseInt(input[2]);
            map[i][3] = Integer.parseInt(input[3]);
            map[i][4] = 0;
        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[1] == a2[1]) {
                    return a1[2] != a2[2] ? a2[2] - a1[2] : a2[3] - a1[3];
                }
                return a2[1] - a1[1];
            }
        });

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                map[i][4] = 1;
            } else {
                if((map[i-1][1] == map[i][1]) && (map[i-1][2] == map[i][2]) && (map[i-1][3] == map[i][3])) {
                    map[i][4] = map[i-1][4];
                } else {
                    map[i][4] = map[i-1][4] + 1;
                }
            }

            if(map[i][0] == m) {
                System.out.println(map[i][4]);
                break;
            }
        }
    }
}