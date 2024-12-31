import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder("*");

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            System.out.println(stb);
            stb.append("*");
        }
    }
}