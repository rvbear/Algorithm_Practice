import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        double w = Double.parseDouble(stk.nextToken());
        double h = Double.parseDouble(stk.nextToken());
        double result = (w*h)/(double)2;
        String results = String.format("%.1f", result);
        System.out.println(results);
        br.close();
    }
}