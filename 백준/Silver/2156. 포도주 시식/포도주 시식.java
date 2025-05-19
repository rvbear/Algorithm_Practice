import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());          // 포도잔의 개수
        int[] glass = new int[N+1];                       // 각 포도잔에 있는 포도주의 양

        for(int i = 1; i <= N; i++)
            glass[i] = Integer.parseInt(br.readLine());

        int[] DP = new int[N+1];
        DP[1] = glass[1];
        if(N > 1) DP[2] = glass[1] + glass[2];
        for(int i = 3; i <= N; i++)
            // 한잔 이전, 두잔 이전과 현재 잔, 세잔 이전과 한잔 이전과 현재 잔의 값을 확인하여 가장 큰 값을 저장
            DP[i] = Math.max(DP[i-1], Math.max(DP[i-2] + glass[i], DP[i-3] + glass[i-1] + glass[i]));

        System.out.println(DP[N]);
        br.close();             // 입력 스트림 버퍼 닫아줌
    }
}