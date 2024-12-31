import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 원하는 년도 입력

        if(N%4 == 0 && (N%100 != 0 || N%400 == 0))      // 4의 배수이면서 100의 배수가 아니거나 400의 배수일 경우
            System.out.println(1);
        else
            System.out.println(0);

        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}