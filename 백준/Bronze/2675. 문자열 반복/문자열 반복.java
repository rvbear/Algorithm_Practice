import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk;
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // 입력 개수

        for(int i = 0; i < N; i++) {                    // N번 반복
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            String b = stk.nextToken();
            for(int j = 0; j < b.length(); j++)         // 문자열의 길이만큼 반복
                for(int k = 0; k < a; k++)              // 원하는 횟수만큼 반복하여 문자열을 저장
                    stb.append(b.charAt(j));
            stb.append("\n");
        }

        System.out.println(stb);
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}