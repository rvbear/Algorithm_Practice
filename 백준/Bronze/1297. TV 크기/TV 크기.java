import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        double d = Double.parseDouble(stk.nextToken());
        double h = Double.parseDouble(stk.nextToken());
        double w = Double.parseDouble(stk.nextToken());

        double sqrt = Math.sqrt(Math.pow(d,2) / (Math.pow(h,2) + Math.pow(w, 2)));

        bw.write(String.valueOf((int)(sqrt*h)) + " " + String.valueOf((int)(sqrt*w)));
        br.close(); bw.close();
    }
}