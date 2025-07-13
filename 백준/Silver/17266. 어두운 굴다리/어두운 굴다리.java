import java.io.*;

public class Main {
    static int n, m;
    static int[] pos;

    public static boolean check(int num) {
        int prev = 0;

        for (int po : pos) {
            if (po - num <= prev) {
                prev = po + num;
            } else {
                return false;
            }
        }

        return n - prev <= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        pos = new int[m];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            pos[i] = Integer.parseInt(temp[i]);
        }

        int start = 1, end = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
