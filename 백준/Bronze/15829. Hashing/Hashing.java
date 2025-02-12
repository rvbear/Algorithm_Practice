import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long ans = 0, pow = 1;

        for (int i = 0; i < L; i++) {
            ans += (s.charAt(i) - 'a' + 1) * pow;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(ans % 1234567891);
    }
}
