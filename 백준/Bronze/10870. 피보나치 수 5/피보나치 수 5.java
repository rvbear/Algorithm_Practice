import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // N번째 피보나치 수열 구하기

        if(N == 0)                                      // 1번째 피보나치 수열은 0
            System.out.println(0);
        else if(N == 1)                                 // 2번째 피보나치 수열은 1
            System.out.println(1);
        else {                                          // 3번째부터는 계산
            int num1 = 0, num2 = 1, sum = 0;            
            for (int i = 1; i < N; i++) {
                sum = num1 + num2;                      // 이전 2개의 값을 더하면 해당 번째의 피보나치 수열
                num1 = num2;                            // 다음 계산을 위해 num2를 num1으로
                num2 = sum;                             // num2를 sum으로 설정
            }
            System.out.println(sum);
        }
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}