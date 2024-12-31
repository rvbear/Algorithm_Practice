import java.io.*;
import java.util.*;

public class Main {
    public static boolean check(int x1, int y1, int x2, int y2, int r) {        // 원의 안에 있는지
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int t = Integer.parseInt(br.readLine());            // 테스트 케이스

        for(int i = 0; i < t; i++) {                        // 테스트 케이스의 수만큼 반복
            int result = 0;
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());         // 시작점의 x 좌표
            int y1 = Integer.parseInt(stk.nextToken());         // 시작점의 y 좌표
            int x2 = Integer.parseInt(stk.nextToken());         // 도착점의 x 좌표
            int y2 = Integer.parseInt(stk.nextToken());         // 도착점의 y 좌표
            int n = Integer.parseInt(br.readLine());        // 행성의 개수
            for(int j = 0; j < n; j++) {
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                int r = Integer.parseInt(stk.nextToken());
                boolean start = check(x1, y1, x, y, r);
                boolean finish = check(x2, y2, x, y, r);
                if(!(start && finish) && (start || finish)) {  // 시작점 혹은 도착점과 반지름을 비교하여 하나만 통과하는 경우
                    result++;
                }
            }
            bw.write(String.valueOf(result + "\n"));
        }

        br.close(); bw.close();
    }
}