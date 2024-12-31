import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());                // 전체 용액의 수
        stk = new StringTokenizer(br.readLine());
        long[] special = new long[N];                           // 용액의 특성
        for(int i = 0; i < N; i++)
            special[i] = Long.parseLong(stk.nextToken());

        int start = 0, end = N-1, num1 = 0, num2 = 0;           // 시작 포인트와 마지막 포인트, 출력에 필요한 값의 인덱스
        long min = 2000000000;                                  // 초기 최솟값 설정
        while(start < end) {
            long temp = special[start] + special[end];          // 원하는 값을 계산
            if(min > Math.abs(temp)) {                          // 절댓값을 비교하여 최솟값보다 작다면
                min = Math.abs(temp);                           // 최솟값 변경
                num1 = start; num2 = end;                       // 해당 인덱스를 저장
            }
            if(temp < 0) start++;                               // 계산값이 0보다 작다면 오른쪽으로 한칸 이동
            else end--;                                         // 작다면 왼쪽으로 한칸 이동
        }

        System.out.println(special[num1] + " " + special[num2]); // 결과값을 출력
        br.close();                                              // 입력 버퍼 스트림 닫아줌
    }
}