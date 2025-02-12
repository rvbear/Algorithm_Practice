import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int ans1 = A + B - C;
        int ans2 = Integer.parseInt(String.valueOf(A) + String.valueOf(B)) - C;

        System.out.println(ans1);
        System.out.println(ans2);
    }
}
