import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int x = Integer.parseInt(br.readLine());        // X 입력 받음
        int y = Integer.parseInt(br.readLine());        // Y 입력 받음

        if(x > 0) {
            if(y > 0) System.out.println(1);            // (양수, 양수)면 제 1사분면
            else System.out.println(4);                 // (양수, 음수)면 제 4사분면
        }
        else {
            if(y > 0) System.out.println(2);            // (음수, 양수)면 제 2사분면
            else System.out.println(3);                 // (음수, 음수)면 제 3사분면
        }

        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}