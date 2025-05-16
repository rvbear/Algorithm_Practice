import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        String line = br.readLine();
        String boom = br.readLine();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            s.push(line.charAt(i));

            if (s.size() >= boom.length()) {
                boolean flag = true;

                for (int j = 0; j < boom.length(); j++) {
                    if (s.get(s.size() - boom.length() + j) != boom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        s.pop();
                    }
                }
            }
        }

        for (char c : s) {
            stb.append(c);
        }

        System.out.println(stb.length() == 0 ? "FRULA" : stb);
    }
}
