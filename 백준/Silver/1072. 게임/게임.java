import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));          // 버퍼 스트림을 통해 입력

        StringTokenizer stk = new StringTokenizer(br.readLine());              // StringTokenizer를 통해 값을 분해
        long X = Long.parseLong(stk.nextToken());                              // 총 게임 횟수
        long Y = Long.parseLong(stk.nextToken());                              // 이긴 횟수
        int Z = (int)(100 * Y/X);                                              // 승률

        if(Z >= 99)                                // 승률이 99보다 크거나 같을 경우 그 승률은 절대 변하지 않음
            System.out.println("-1");
        else {                                     // 그 외의 경우
            // z+1 = 100(y+a) / (x+a) 를 계산하여 a=(zx+x-100Y)/(99-z) 라는 수식을 완성
            // 소수점을 다 삭제하기 때문에 Math.ceil 함수 사용
            int count = (int)Math.ceil((Z*X + X - 100*Y) / (double)(99 - Z));
            System.out.println(count);
        }

        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}