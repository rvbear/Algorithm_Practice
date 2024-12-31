import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(stk.nextToken());
        int n2 = Integer.parseInt(stk.nextToken());

        if(n1 < n2)
            System.out.println("<");
        else if(n1 > n2)
            System.out.println(">");
        else
            System.out.println("==");

        br.close();
    }
}