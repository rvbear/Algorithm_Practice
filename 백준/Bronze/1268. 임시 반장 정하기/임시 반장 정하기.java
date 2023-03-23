import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] same;       // 같은 학생이 여러번 반이 겹칠 경우를 방지하기 위한 배열
    public static void init(int N) {        // 배열 초기화
        for(int i = 0; i < N; i++)
            same[i] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 사용하여 입력
        StringTokenizer stk;        // StringTokenizer 사용

        int N = Integer.parseInt(br.readLine());            // 반의 학생 수를 입력
        int[][] student = new int[N][5];                    // 비교를 위한 키값

        int index = 0;      // 0~4까지 따로 돌아갈 수 있는 index
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());       // StringTokenizer를 사용
            while (stk.hasMoreTokens())                     // 남은 Token이 없을 때까지
                student[i][index++] = Integer.parseInt(stk.nextToken());
            index = 0;      // index 초기화
        }

        same = new boolean[N];      // 배열의 크기 생성
        int count = 0, max = 0, boss = 1;       // count : 같은 학생 수, max : 가장 많이 겹친 학생 수, boss = 반장의 번호
        for(int i = 0; i < N; i++) {            // N번 반복
            for (int j = 0; j < N; j++) {       // N번 반복
                if (i == j) continue;           // 같은 학생일 경우 비교하지 않도록 continue
                for (int k = 0; k < 5; k++)     // 1~5학년까지의 반을 비교
                    if (student[i][k] == student[j][k])     // 같은 반일 경우
                        if(same[j] != true) {               // 이미 같은 반이 된 적 없을 경우
                            same[j] = true;                 // 같은 반이 된 적 있다고 표시
                            count++;                        // 같은 학생 수 증가
                        }
            }
            if(max < count) {           // count가 max값보다 클 경우
                max = count;            // max값을 바꿔주고
                boss = i + 1;           // 반장 번호를 저장
            }
            count = 0;                  // 초기화
            init(N);                    // 초기화
        }

        System.out.println(boss);       // 반장 번호를 출력
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}