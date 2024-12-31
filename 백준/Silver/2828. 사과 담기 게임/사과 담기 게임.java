import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());           // StringTokenizer를 사용하여 분해

        int N = Integer.parseInt(stk.nextToken());      // 스크린이 나눠진 칸의 개수
        int M = Integer.parseInt(stk.nextToken());      // 바구니의 크기
        int J = Integer.parseInt(br.readLine());        // 떨어지는 사과의 개수

        int start = 1, fin = M, count = 0;              // 바구니의 시작, 끝, 움직이는 개수

        for(int i = 0; i < J; i++) {              // J번 반복
            int apple = Integer.parseInt(br.readLine());       // 사과의 위치 확인
            if(start <= apple && apple <= fin) continue;       // 사과의 위치가 바구니와 같다면 continue
            if(start > apple) {                                // 사과가 바구니 왼쪽에 있다면
                fin -= (start - apple);                        // 바구니를 이동하고 이동한만큼 count를 증가
                count += (start - apple);                       
                start = apple;
            }
            else {                                             // 사과가 바구니 오른쪽에 있다면
                start += (apple - fin);                        // 바구니를 이동하고 이동한만큼 count 증가
                count += (apple - fin);
                fin = apple;
            }
        }

        System.out.println(count);          // count를 출력

        br.close();     // 입력 버퍼 스트림을 닫아줌
    }
}