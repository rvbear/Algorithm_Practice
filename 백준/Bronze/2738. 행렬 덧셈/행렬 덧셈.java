import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][]hang = new int[N][M];

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                hang[i][j] += Integer.parseInt(stk.nextToken());
        }

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                hang[i][j] += Integer.parseInt(stk.nextToken());
                System.out.print(hang[i][j] + " ");
            }
            System.out.println();
        }

        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}