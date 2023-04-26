import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long min = Long.parseLong(stk.nextToken()) - Long.parseLong(stk.nextToken());

        if(min < 0)
            System.out.println(-1 * min);
        else
            System.out.println(min);

        br.close();
    }
}