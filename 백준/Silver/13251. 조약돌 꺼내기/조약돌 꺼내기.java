import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int n = 0;
        int[] color = new int[m];
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(input[i]);
            n += color[i];
        }

        int k = Integer.parseInt(br.readLine());

        if (m == 1 || k == 1) {
            System.out.println(1.0);
            return;
        }

        double ans = 0;
        for (int i = 0; i < m; i++) {
            double value = 1;
            for (int j = 0; j < k; j++) {
                value *= ((double) (color[i] - j) / (n - j));
            }
            ans += value;
        }

        System.out.println(ans);
    }
}
