import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (m != 0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(input[i])] = true;
            }
        }

        int res = Math.abs(n - 100);

        for (int i = 0; i < 1000000; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                res = Math.min(res, len + Math.abs(n - i));
            }
        }

        System.out.println(res);
    }
}
