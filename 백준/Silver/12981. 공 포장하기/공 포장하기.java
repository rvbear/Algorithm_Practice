import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(stk.nextToken());          // 빨간색 공의 개수
        int G = Integer.parseInt(stk.nextToken());          // 초록색 공의 개수
        int B = Integer.parseInt(stk.nextToken());          // 파란색 공의 개수

        int box = 0;                                        // 필요한 박스의 개수
        if(R == G && G == B) {
            System.out.println(R);                          // 값이 모두 같다면 하나의 값을 출력
            return;
        }
        else {                                              // 가장 작은 수를 확인해서 그만큼을 box에 저장
            if(R <= G && R <= B) box = R;
            else if(G <= R && G <= B) box = G;
            else box = B;
            R -= box; G -= box; B -= box;                   // 모든 값에서 box의 값을 빼줌

            box += R/3; box += G/3; box += B/3;             // 각각 3으로 나눈 몫을 더해줌
            if(R%3 != 0 || G%3 != 0 || B%3 != 0) {          // 3으로 나눈 나머지가 존재할 경우
                if (((R % 3) + (G % 3) + (B % 3)) <= 2) box += 1;       // 그 합이 2보다 작거나 같다면 1을 더해주고
                else box += 2;                                          // 아니라면 2를 더해줌
            }
        }

        System.out.println(box);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}