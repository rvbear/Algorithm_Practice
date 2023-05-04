import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());            // 계단의 개수
        int[] stairs = new int[N+1];
        int[] DP = new int[N+1];

        for(int i = 1; i <= N; i++)                         // 각 계단마다 점수를 입력
            stairs[i] = Integer.parseInt(br.readLine());

        DP[1] = stairs[1];                                  // 계산을 위한 시작값을 넣어줌
        if(N >= 2)                                          // (N = 2)인 경우
            DP[2] = stairs[1] + stairs[2];
        for(int i = 3; i <= N; i++)                         // (N >= 3)인 경우
            // 두 계단 아래와 한 계단 아래의 값을 비교하여 큰 값과 현재 계단의 점수를 더함
            DP[i] = Math.max(DP[i-2], DP[i-3] + stairs[i-1]) + stairs[i];

        System.out.println(DP[N]);                          // 누적된 최댓값을 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}