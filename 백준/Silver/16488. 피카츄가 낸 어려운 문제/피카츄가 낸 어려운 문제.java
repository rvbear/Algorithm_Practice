import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        long n = Integer.parseInt(stk.nextToken());          // 변의 길이
        long k = Integer.parseInt(stk.nextToken());          // 점의 개수

        bw.write(String.valueOf(k * n * n));
        br.close(); bw.close();
    }
}