import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && a[i] >= s.peek()) {
                s.pop();
            }

            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(a[i]);
        }

        for (int num : res) {
            stb.append(num).append(" ");
        }

        System.out.println(stb);
    }
}
