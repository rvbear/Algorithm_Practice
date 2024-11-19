import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));         // 버퍼 스트림을 통해 출력

        int[][] room = new int[15][15];                     // 호실에 있는 사람 수
        for(int i = 0; i < 15; i++)
            for(int j = 1; j <= 14; j++) {
                if(j == 1)                                  // i층 1호실일 경우
                    room[i][j] = 1;
                else if(i == 0)                             // 0층일 경우
                    room[i][j] = j;
                else                                        // 그 외의 경우
                    for(int k = 1; k <= j; k++)
                        room[i][j] += room[i-1][k];
            }

        int N = Integer.parseInt(br.readLine());            // Test Case 개수

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());        // 층
            int b = Integer.parseInt(br.readLine());        // 호수
            bw.write(String.valueOf(room[a][b]) + "\n");
        }

        br.close(); bw.close();                             // 입,출력 버퍼 스트림 닫아줌
    }
}