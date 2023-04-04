import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 원하는 단수 입력

        for(int i = 1; i <= N; i++)
            System.out.println(i);

        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}