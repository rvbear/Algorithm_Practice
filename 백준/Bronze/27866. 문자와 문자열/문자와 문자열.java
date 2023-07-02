import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        String word = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(word.charAt(i-1));
        br.close();                 // 입력 버퍼 스트림 닫아줌
    }
}