import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    public static boolean check_1() {               // 네 변의 길이가 같은지 확인하는 메서드
        double len1 = Math.sqrt(Math.pow(arr[1][0] - arr[0][0], 2) + Math.pow(arr[1][1] - arr[0][1], 2));
        double len2 = Math.sqrt(Math.pow(arr[2][0] - arr[0][0], 2) + Math.pow(arr[2][1] - arr[0][1], 2));
        double len3 = Math.sqrt(Math.pow(arr[3][0] - arr[1][0], 2) + Math.pow(arr[3][1] - arr[1][1], 2));
        double len4 = Math.sqrt(Math.pow(arr[3][0] - arr[2][0], 2) + Math.pow(arr[3][1] - arr[2][1], 2));
        return len1 == len2 && len2 == len3 && len3 == len4 ? true : false;
    }
    public static boolean check_2() {               // 두 대각선의 길이가 같은지 확인하는 메서드
        double r1 = Math.sqrt(Math.pow(arr[3][0] - arr[0][0], 2) + Math.pow(arr[3][1] - arr[0][1], 2));
        double r2 = Math.sqrt(Math.pow(arr[2][0] - arr[1][0], 2) + Math.pow(arr[2][1] - arr[1][1], 2));
        return r1 == r2 ? true : false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());    // test case 수

        for(int i = 0; i < t; i++) {
            arr = new int[4][2];                    // 정사각형을 만드려고 하는 네 점
            for(int j = 0; j < 4; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(stk.nextToken());
                arr[j][1] = Integer.parseInt(stk.nextToken());
            }
            Arrays.sort(arr, (o1, o2) -> {          // 오름차순으로 정렬, 첫번째 점이 같을 경우 두번째 점을 기준으로 오름차순
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            });
            bw.write(String.valueOf(check_1() && check_2() ? 1 : 0) + "\n");
        }

        br.close(); bw.close();
    }
}