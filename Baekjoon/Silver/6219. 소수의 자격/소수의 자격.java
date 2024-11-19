import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());          // 왼쪽 범위
        int B = Integer.parseInt(stk.nextToken());          // 오른쪽 범위
        int D = Integer.parseInt(stk.nextToken());          // 판별할 숫자
        int MAX = 4000000;

        boolean[] num = new boolean[MAX+1];
        for(int i = 2; i <= MAX; i++)                       // 에라토스테네스의 체를 사용하여 소수를 판별
            for(int j = i * 2; j <= MAX; j += i)
                num[j] = true;

        int count = 0;                                      // 숫자가 들어간 개수
        for(int i = A; i <= B; i++) {                       // A부터 B까지 반복
            int temp = i;
            if(num[i]) continue;                            // 소수가 아니라면 continue
            while (temp != 0) {                             // 소수라면 해당 숫자가 있는지 확인
                if(temp % 10 == D) {
                    count++;
                    break;
                }
                temp /= 10;
            }
        }

        System.out.println(count);                          // 결과값을 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}