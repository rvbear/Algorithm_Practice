import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 4; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());     // 첫번째 직사각형의 왼쪽 아래 x 좌표
            int y1 = Integer.parseInt(stk.nextToken());     // 첫번째 직사각형의 왼쪽 아래 y 좌표
            int p1 = Integer.parseInt(stk.nextToken());     // 첫번째 직사각형의 오른쪽 위 x 좌표
            int q1 = Integer.parseInt(stk.nextToken());     // 첫번째 직사각형의 오른쪽 위 y 좌표
            int x2 = Integer.parseInt(stk.nextToken());     // 두번째 직사각형의 왼쪽 아래 x 좌표
            int y2 = Integer.parseInt(stk.nextToken());     // 두번째 직사각형의 왼쪽 아래 y 좌표
            int p2 = Integer.parseInt(stk.nextToken());     // 두번째 직사각형의 오른쪽 위 x 좌표
            int q2 = Integer.parseInt(stk.nextToken());     // 두번째 직사각형의 오른쪽 위 y 좌표

            // 공통 부분이 없는 경우
            if(p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
                bw.write("d\n");
            }
            // 한 점에서 만나는 경우
            else if((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
                bw.write("c\n");
            }
            // 한 선분에서 만나는 경우
            else if(p1 == x2 || q1 == y2 || p2 == x1 || y1 == q2) {
                bw.write("b\n");
            }
            // 공통 부분이 직사각형인 경우
            else {
                bw.write("a\n");
            }
        }

        br.close(); bw.close();
    }
}