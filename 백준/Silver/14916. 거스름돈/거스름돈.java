import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 거스름돈 액수

        if(N == 1 || N == 3)                                // 거슬러 줄 수 없는 금액
            System.out.println(-1);
        else if(N % 5 == 0)                                 // 5로 나누어 떨어질 경우
            System.out.println(N / 5);
        else if(N % 5 == 1 || N % 5 == 4)                   // 나머지가 1 이거나 4일 경우 (몫 + 2)
            System.out.println(N / 5 + 2);
        else if(N % 5 == 2)                                 // 나머지가 2일 경우 (몫 + 1)
            System.out.println(N / 5 + 1);
        else if(N % 5 == 3)                                                // 나머지가 3일 경우 (몫 + 3)
            System.out.println(N / 5 + 3);

        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}