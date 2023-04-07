import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        StringTokenizer stk;

        String question;
        while((question = br.readLine()) != null) {
            stk = new StringTokenizer(question);
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            stb.append(a + b).append("\n");
        }

        System.out.println(stb);
        br.close();
    }
}