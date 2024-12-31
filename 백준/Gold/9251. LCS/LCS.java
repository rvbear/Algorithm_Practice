import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        String row = br.readLine();                                 // 첫번째 문자열
        String col = br.readLine();                                 // 두번째 문자열

        long[][] dp = new long[row.length()+1][col.length()+1];     // 배열 생성
        for(int i = 1; i <= row.length(); i++) {                    // dp 시작
            for(int j = 1; j <= col.length(); j++) {
                if(row.charAt(i-1) == col.charAt(j-1)) {            // i-1과 j-1번째 문자가 서로 같다면 대각선 위의 값에 +1
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {                                              // 다르다면 이전 행과 이전 열 중 큰 값을 저장
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[row.length()][col.length()]);         // 결과값을 출력
        br.close();                                                 // 입력 버퍼 스트림 닫아줌
    }
}