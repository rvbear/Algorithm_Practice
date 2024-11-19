import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 0; i < 5; i++)
            sum += Math.pow(Integer.parseInt(stk.nextToken()), 2);

        System.out.println(sum % 10);
    }
}