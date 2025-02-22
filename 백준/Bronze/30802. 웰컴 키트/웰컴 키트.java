import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sizes = br.readLine().split(" ");
        String[] group = br.readLine().split(" ");

        int t = Integer.parseInt(group[0]);
        int tNeed = 0;
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(sizes[i]);
            tNeed += num % t == 0 ? num / t : num / t + 1;
        }

        int p = Integer.parseInt(group[1]);
        int pNeed = n / p;
        int pExtra = n % p;

        System.out.println(tNeed);
        System.out.println(pNeed + " " + pExtra);
    }
}
