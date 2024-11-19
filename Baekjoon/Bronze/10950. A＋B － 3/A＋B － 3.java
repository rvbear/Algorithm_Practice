import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            stb.append(a+b).append("\n");
        }

        System.out.println(stb);
        br.close();
    }
}