import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 값을 입력 받음
        int result = 0;                                     // 결과값

        for(int i = 0; i < N; i++) {                        // N까지 반복
            int num = i; int sum = 0;                

            while(num != 0) {                               // 각 자릿수를 더해줌
                sum += num % 10;
                num /= 10;
            }

            if(i + sum == N) {                              // 숫자와 그 숫자의 자릿수의 합이 N과 같다면
                result = i;
                break;
            }
        }

        System.out.println(result);
        br.close();             // 입력 버퍼 스트림 닫아줌
    }
}