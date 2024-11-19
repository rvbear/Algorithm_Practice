import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());          // StringTokenizer를 사용해 분해

        int a = Integer.parseInt(stk.nextToken());      // 첫번째 값 저장
        int b = Integer.parseInt(stk.nextToken());      // 두번째 값 저장

        System.out.println((double)a/b);        // 첫번째 값에서 두번째 값을 나눠준 값을 출력
        br.close();                     // 입력 버퍼 스트림 닫아줌
    }
}