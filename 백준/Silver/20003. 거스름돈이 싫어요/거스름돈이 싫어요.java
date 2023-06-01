import java.io.*;
import java.util.*;

public class Main {
    public static long GCD(long a, long b) {           // 유클리도 호제법
        if(a%b == 0) return b;
        return GCD(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());                    // 아이템의 개수
        long[] A = new long[N];                                     // 분자를 저장할 배열
        long[] B = new long[N];                                     // 분모를 저장할 배열
        long temp = 0, gcd = 0;                                     // temp = 최종 분모, gcd = GCD 함수 반환값 저장

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(stk.nextToken());
            B[i] = Long.parseLong(stk.nextToken());
            if(i == 0) temp = B[0];                                 // 처음 입력 받았을 경우 초깃값으로 저장
            else {                                                  // 두번째부터는 최대공약수를 구하여 temp에 저장
                gcd = GCD(temp, B[i]);
                temp = (temp * B[i]) / gcd;
            }
        }

        for(int i = 0; i < N; i++) A[i] *= temp / B[i];             // 분모가 늘어난만큼 분자도 늘려줌

        for(int i = 1; i < N; i++) A[0] = GCD(A[0], A[i]);          // 분자들의 최대공약수를 구해줌

        gcd = GCD(temp, A[0]);                                      // 최종 분자와 최종 분모의 최대공약수를 구해줌
        System.out.println(A[0] / gcd + " " + temp / gcd);          // 최대공약수를 나눠준 값을 출력
        br.close();                                                 // 입력 버퍼 스트림 닫아줌
    }
}