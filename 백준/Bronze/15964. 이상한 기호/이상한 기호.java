import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());
        
        System.out.println((a+b)*(a-b));
        br.close();
    }
}