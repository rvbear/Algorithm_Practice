import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        String word = "";
        while((word = br.readLine()) != null)                   // null을 입력받을 때까지 반복
            System.out.println(word);                           // 버퍼 스트림에 출력

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}