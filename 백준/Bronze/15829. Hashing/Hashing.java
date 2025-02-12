import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        char[] alphabet = br.readLine().toCharArray();
        int ans = 0;

        for (int i = 0; i < L; i++) {
            int n = alphabet[i] - 'a' + 1;
            ans += (n * (int)Math.pow(31, i));
        }

        System.out.println(ans);
    }
}
