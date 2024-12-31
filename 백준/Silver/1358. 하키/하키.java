import java.io.*;
import java.util.*;

public class Main {
    public static boolean check(int x1, int y1, int x2, int y2, int r) {        // 원의 안에 있는 점인지 판별하는 메서드
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(stk.nextToken());          // 직사각형의 너비
        int h = Integer.parseInt(stk.nextToken());          // 직사각형의 높이
        int x = Integer.parseInt(stk.nextToken());          // 왼쪽 아래 모서리의 x 좌표
        int y = Integer.parseInt(stk.nextToken());          // 왼쪽 아래 모서리의 y 좌표
        int p = Integer.parseInt(stk.nextToken());          // 선수의 수

        int count = 0;
        for(int i = 0; i < p; i++) {
            stk = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(stk.nextToken());     // 선수의 x 좌표
            int py = Integer.parseInt(stk.nextToken());     // 선수의 y 좌표

            if(x <= px && px <= x+w && y <= py && py <= y+h) {                  // 직사각형에 포함되는지
                count++;
            } else if(px <= x && check(x, y+h/2, px, py, h/2)) {          // 왼쪽 반원에 포함되는지
                count++;
            } else if(x+w <= px && check(x+w, y+h/2, px, py, h/2)) {   // 오른쪽 반원에 포함되는지
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}