import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(stk.nextToken());      // 낮동안 올라가는 높이
        int B = Integer.parseInt(stk.nextToken());      // 저녁에 미끄러지는 높이
        int V = Integer.parseInt(stk.nextToken());      // 나무의 높이

        // (V-B)가 (A-B)로 나누어떨어질 경우 나누어진 몫만 아니라면 몫 + 1
        int day = (V-B)%(A-B) == 0 ? (V-B)/(A-B) : (V-B)/(A-B) + 1;

        System.out.println(day);                        // 걸린 일수를 출력
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}