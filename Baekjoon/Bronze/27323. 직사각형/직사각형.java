import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int A = Integer.parseInt(br.readLine());        // 세로 길이
        int B = Integer.parseInt(br.readLine());        // 가로 길이
        
        System.out.println(A*B);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}