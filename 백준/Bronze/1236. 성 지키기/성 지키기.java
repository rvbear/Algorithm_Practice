import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력

        StringTokenizer stk = new StringTokenizer(br.readLine());       // StringTonkenizer을 사용하여 행과 열을 입력받음

        int N = Integer.parseInt(stk.nextToken());      // 행
        int M = Integer.parseInt(stk.nextToken());      // 열

        int[][] castle = new int[N][M];     // 성을 2차원 배열로 생성
        for(int i = 0; i < N; i++) {        // 행 단위로 입력하고 charAt을 사용하여 배열에 값을 입력
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                castle[i][j] = line.charAt(j);
        }

        int gaurd1 = 0, gaurd2 = 0;     // 행과 열에 필요한 경비원 수

        for(int i = 0; i < N; i++) {        // 행의 경비원 수를 확인
            boolean  flag = false;          // 경비원의 존재를 확인
            for (int j = 0; j < M; j++)
                if (castle[i][j] == 'X') {      // 경비원이 존재하면
                    flag = true;                // 존재를 진실로 만듦
                    break;
                }
            if(!flag)               // 한 행에 경비원이 존재하지 않으면
                gaurd1++;           // 필요한 경비원 수를 증가
        }


        for(int j = 0; j < M; j++) {        // 열의 경비원 수를 확인
            boolean  flag = false;          // 경비원의 존재를 확인
            for (int i = 0; i < N; i++)         
                if(castle[i][j] == 'X') {       // 경비원이 존재하면
                    flag = true;                // 존재를 진실로 만듦
                    break;
                }
            if(!flag)               // 한 열에 경비원이 존재하지 않으면
                gaurd2++;           // 필요한 경비원 수를 증가
        }

        br.close();         // 입력 버퍼스트림 닫아줌
        bw.write(String.valueOf(Math.max(gaurd1, gaurd2)));         // Math.max() 함수를 사용하여 둘 중 큰 값을 출력
        bw.close();         // 출력 버퍼스트림 닫아줌
    }
}