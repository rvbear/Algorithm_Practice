import java.io.*;
import java.util.*;

public class Main {
    public static int GCD(int a, int b) {       // 유클리드 호제법
        if(b == 0) return a;
        return GCD(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] num = new int[4];                                     // 값을 저장할 배열
        for(int i = 0; i < 4; i++) {
            if(i == 2) stk = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(stk.nextToken());
        }

        int c = num[0]*num[3] + num[2]*num[1];                      // 두 분수를 더했을 때 나오는 분자
        int p = num[1]*num[3];                                      // 두 분수를 더했을 때 나오는 분모
        int gcd = GCD(c, p);                                        // 분자와 분모의 최대공약수 구해줌

        System.out.println(c/gcd + " " + p/gcd);                    // 분자 분모에 최대공약수를 나눈 값을 출력
        br.close();                                                 // 입력 버퍼 스트림 닫아줌
    }
}