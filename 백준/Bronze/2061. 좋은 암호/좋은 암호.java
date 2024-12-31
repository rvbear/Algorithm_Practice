import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        BigInteger K = new BigInteger(stk.nextToken());          // 키 값
        BigInteger L = new BigInteger(stk.nextToken());          // 정수

        int index = 2;
        while(true) {   
            BigInteger min = BigInteger.valueOf(index);          // 값을 BigInteger로 변환
            if(min.equals(L)) break;                             // index 값이 L과 같다면 반복문 빠져나옴
            if(K.remainder(min).compareTo(BigInteger.ZERO) == 0) {      // 만약 index값으로 나눗셈 연산을 했을 때 0이 나온다면
                System.out.println("BAD " + min.toString());            // 그 값을 출력하고 종료
                return;
            }
            index++;
        }

        System.out.println("GOOD");                                 // 아니라면 GOOD 출력
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}