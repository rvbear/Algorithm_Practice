import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 사람의 수
        int count = 0;                                      // 열린 창문의 개수
        for(int i = 1; i*i <= N; i++) count++;              // 수의 제곱이 N보다 작거나 같을 경우 count 증가

        System.out.println(count);                          // 값 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}