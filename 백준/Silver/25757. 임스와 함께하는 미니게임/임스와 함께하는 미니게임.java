import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String game = input[1];

        Set<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            cnt += set.contains(s) ? 0 : 1;
            set.add(s);
        }

        int num = 0;
        if (game.equals("Y")) {
            num = 1;
        } else if (game.equals("F")) {
            num = 2;
        } else if (game.equals("O")) {
            num = 3;
        }

        System.out.println(cnt / num);
    }
}
