import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int target = 9 * m / 10 + ((9 * m % 10 == 0) ? 0 : 1);
        int[] a = new int[n];

        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            int value = map.getOrDefault(a[i], 0) + 1;

            if(value >= target) {
                System.out.println("YES");
                return;
            }

            map.put(a[i], value);
        }

        for(int i = 1; i <= n-m; i++) {
            map.put(a[i-1], map.get(a[i-1]) - 1);

            int value = map.getOrDefault(a[m+i-1], 0) + 1;
            if(value >= target) {
                System.out.println("YES");
                return;
            }

            map.put(a[m+i-1], value);
        }

        System.out.println("NO");
    }
}