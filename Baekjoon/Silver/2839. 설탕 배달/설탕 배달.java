import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 배달해야하는 킬로그램 수

        int count = 0;                                      // 봉지 개수

        if(N % 5 == 0)                                      // 5로만 이루어진 경우
            count = N/5;
        else if ((N % 5 == 1 || N % 5 == 3) && N > 5)      // 5 여러 개와 3 한 개 or 두 개로 이루어진 경우
            count = N/5 + 1;
        else if ((N % 5 == 2 || N % 5 == 4) && N > 10)      // 5 여러 개와 3 세 개로 이루어진 경우
            count = N/5 + 2;
        else if (N % 3 == 0)                                // 3으로만 이루어진 경우
            count = N/3;
        else                                                // 이루어질 수 없는 경우
            count = -1;

        System.out.println(count);

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}