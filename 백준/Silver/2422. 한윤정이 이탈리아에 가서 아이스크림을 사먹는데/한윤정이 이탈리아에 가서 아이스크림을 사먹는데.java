import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력받음

        StringTokenizer stk = new StringTokenizer(br.readLine());       // StringTokenizer를 사용하여 분해
        int N = Integer.parseInt(stk.nextToken());      // N을 저장
        int M = Integer.parseInt(stk.nextToken());      // M을 저장

        boolean[][] com = new boolean[N+1][N+1];        // 조합을 저장할 배열
        for(int i = 0; i < M; i++) {                    // M번 반복
            stk = new StringTokenizer(br.readLine());           // 조합을 입력
            int com1 = Integer.parseInt(stk.nextToken());        // 조합의 첫번째 수를 저장
            int com2 = Integer.parseInt(stk.nextToken());        // 조합의 두번째 수를 저장
            com[com1][com2] = true;             // 조합을 boolean 배열에 저장
            com[com2][com1] = true;             // 조합을 boolean 배열에 저장
        }

        int count = 0;      // 가능한 조합의 수
        for(int i = 1; i <= N; i++)         // N번 반복
            for(int j = i+1; j <= N; j++) {     // N-1번 반복
                if (com[i][j]) continue;        // 조합에 걸린다면 continue
                for(int k = j+1; k <= N; k++)       // N-2번 반복
                    if(!com[j][k] && !com[k][i])    // 조합에 걸리지 않는다면 count 1 증가
                        count++;
            }

        System.out.println(count);          // count를 출력
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}