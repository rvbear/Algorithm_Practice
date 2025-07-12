import java.io.*;

public class Main {
    public static int changeState(int x) {
        return x == 1 ? 0 : 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] switchState = new int[n + 1];

        String[] temp = br.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            switchState[i] = Integer.parseInt(temp[i - 1]);
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            temp = br.readLine().split(" ");
            int gender = Integer.parseInt(temp[0]);
            int num = Integer.parseInt(temp[1]);

            if (gender == 1) {
                for (int j = num; j < n + 1; j += num) {
                    switchState[j] = changeState(switchState[j]);
                }
            } else if (gender == 2) {
                int x = num - 1, y = num + 1;
                for (; x > 0 && y < n + 1; x--, y++) {
                    if (switchState[x] != switchState[y]) {
                        break;
                    }
                }

                for (int j = x + 1; j < y; j++) {
                    switchState[j] = changeState(switchState[j]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            stb.append(switchState[i]).append(" ");
            if (i % 20 == 0) {
                stb.append("\n");
            }
        }

        System.out.println(stb);
    }
}
