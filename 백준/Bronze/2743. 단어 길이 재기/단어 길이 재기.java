import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        System.out.println((br.readLine()).length());

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}