import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringBuilder stb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());                // Test Case 개수
        for(int i = 0; i < N; i++) {
            int room = Integer.parseInt(br.readLine());         // 방의 개수
            int count = 0;                                      // 도망간 사람의 수
            for (int j = 1; j * j <= room; j++)                 // 수의 제곱이 방의 개수보다 작다면 count 증가
                count++;
            stb.append(count).append("\n");
        }

        System.out.println(stb);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}