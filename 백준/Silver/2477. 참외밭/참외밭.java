import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[6][2];
        int max_x = 0, max_y = 0, x_index = 0, y_index = 0;
        for(int i = 0; i < 6; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());      // 1:동, 2:서, 3:남, 4:북
            arr[i][1] = Integer.parseInt(stk.nextToken());      // 길이
            if(arr[i][0] < 3 && arr[i][1] > max_x) {            // 가장 긴 가로 길이
                max_x = arr[i][1];
                x_index = i;                                    // 해당 가로 길이 인덱스
            } else if(arr[i][0] > 2 && arr[i][1] > max_y){      // 가장 긴 세로 길이
                max_y = arr[i][1];
                y_index = i;                                    // 해당 세로 길이 인덱스
            }
        }

        int minus = arr[(x_index+3) % 6][1] * arr[(y_index+3) % 6][1];      // 인덱스+3 % 6 한 위치가 빼야하는 부분의 위치
        System.out.println((max_x * max_y - minus) * n);        // (큰 직사각형의 넓이 - 빼야할 부분) * 1m^2 당 참외의 개수
        br.close();
    }
}