import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long sum = 0;

        while(stk.hasMoreTokens())
            sum += Long.parseLong(stk.nextToken());

        System.out.println(sum);
        br.close();          // 입력 버퍼 스트림 닫아줌
    }
}