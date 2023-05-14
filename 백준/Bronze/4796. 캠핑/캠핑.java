import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk;
        StringBuilder stb = new StringBuilder();
        int i = 1;                                              // Case 숫자를 위한 변수

        while(true) {
            stk = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(stk.nextToken());          // 가능한 날짜
            int P = Integer.parseInt(stk.nextToken());          // 연속된 날짜
            int V = Integer.parseInt(stk.nextToken());          // 휴가 날짜
            if(L == 0 && P == 0 && V == 0) break;               // 모두 0이면 break;
            stb.append("Case " + i + ": ");                     // 출력 형식 맞춰줌
            // 휴가 날짜 / 연속된 날짜 * 가능한 날짜 + (휴가 날짜 % 연속된 날짜)가 가능한 날짜보다 작다면 if문, 아니라면 else문
            if((V%P) < L) stb.append((V/P) * L + (V%P)).append("\n");
            else stb.append((V/P) * L + L).append("\n");
            i++;                                                 // Case 숫자 늘려줌
        }

        System.out.print(stb);  // 저장된 값을 출력
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}