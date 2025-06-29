import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]);
            int[] num = new int[20];
            int res = 0;

            for (int j = 0; j < 20; j++) {
                num[j] = Integer.parseInt(input[j + 1]);
            }

            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (num[k] > num[j]) {
                        res++;
                    }
                }
            }

            stb.append(idx).append(" ").append(res).append("\n");
        }

        System.out.print(stb);
    }
}
