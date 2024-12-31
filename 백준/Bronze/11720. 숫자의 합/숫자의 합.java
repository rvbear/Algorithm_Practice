import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 입력할 값의 개수
        String answer = br.readLine();                  // 값을 입력

        int sum = 0;
        for(int i = 0; i < N; i++)
            sum += answer.charAt(i) - '0';              // char형으로 바꿔서 '0'을 빼준 값을 sum에 더해줌

        System.out.println(sum);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}