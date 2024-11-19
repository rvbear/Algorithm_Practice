import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        System.out.println(Integer.parseInt(stk.nextToken()) * Integer.parseInt(stk.nextToken()));
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}