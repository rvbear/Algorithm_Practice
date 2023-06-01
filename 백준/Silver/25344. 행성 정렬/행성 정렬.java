import java.io.*;
import java.util.*;

public class Main {
    public static long GCD(long a, long b) {            // 유클리드 호제법
        if(a%b == 0) return b;
        return GCD(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());        // 행성의 개수
        stk = new StringTokenizer(br.readLine());
        long[] T = new long[N-2];                       // 주기를 저장할 배열
        for(int i = 0; i < N-2; i++)
            T[i] = Long.parseLong(stk.nextToken());

        long temp = T[0];                               // 행성 정렬주기
        for(int i = 1; i < N-2; i++)                    // 각 주기들의 최대공약수를 구해서 정렬 주기를 구해줌
            temp = temp * T[i] / GCD(temp, T[i]);

        System.out.println(temp);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}