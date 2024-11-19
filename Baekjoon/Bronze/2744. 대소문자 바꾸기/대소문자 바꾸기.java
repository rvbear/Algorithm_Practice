import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        String line = br.readLine();
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(Character.isUpperCase(c)) {
                stb.append(Character.toLowerCase(c));
            } else {
                stb.append(Character.toUpperCase(c));
            }
        }

        System.out.println(stb);
        br.close();
    }
}