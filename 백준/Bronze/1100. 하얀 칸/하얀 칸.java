import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림으로 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림으로 출력

        char[][] chess = new char[8][8];        // 체스판 설정

        int count = 0;      // 말의 개수를 카운트하기 위한 변수

        for(int i = 0; i < 8; i++) {        // 체스판에 값을 입력
            String line = br.readLine();        // 한 라인씩 입력
            for (int j = 0; j < 8; j++) {
                chess[i][j] = line.charAt(j);       // char로 분해하여 체스판 배열에 넣어줌
                // 하얀색판은 (0,0), (0,2), (1,1) 등 i, j 모두 짝수이거나 모두 홀수인 경우이다.
                if(i % 2 == 0 && j % 2 == 0)    // i, j 모두 짝수인 경우
                    if(chess[i][j] == 'F')      // 해당 칸에 말이 있다면 count를 증가
                        count++;
                if(i % 2 == 1 && j % 2 == 1)    // i, j 모두 홀수인 경우
                    if(chess[i][j] == 'F')      // 해당 칸에 말이 있다면 count를 증가
                        count++;
            }
        }

        br.close();                             // 입력 버퍼 스트림 닫아줌
        bw.write(String.valueOf(count));        // 말의 개수 출력
        bw.newLine();                           // 개행
        bw.close();                             // 출력 버퍼 스트림 닫아줌
    }
}