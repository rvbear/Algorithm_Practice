import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(stk.nextToken());
        long y1 = Long.parseLong(stk.nextToken());
        long r1 = Long.parseLong(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        long x2 = Long.parseLong(stk.nextToken());
        long y2 = Long.parseLong(stk.nextToken());
        long r2 = Long.parseLong(stk.nextToken());

        if((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) < (r1+r2) * (r1+r2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        br.close();
    }
}