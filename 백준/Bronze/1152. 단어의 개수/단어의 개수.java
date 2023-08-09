import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        System.out.println(stk.countTokens());
        br.close();
    }
}