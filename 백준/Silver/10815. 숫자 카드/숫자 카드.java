import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());                        // 가지고 있는 카드의 개수
        HashSet<Long> s_card = new HashSet<>();                         // 카드의 숫자를 저장할 배열
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)                                      // HashSet에 값을 저장
            s_card.add(Long.parseLong(stk.nextToken()));

        int M = Integer.parseInt(br.readLine());                        // 비교할 카드의 개수
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {                                
            if(s_card.contains(Long.parseLong(stk.nextToken())))        // 값을 비교해서 있으면 1을
                System.out.print("1 ");
            else                                                        // 없으면 0을 출력
                System.out.print("0 ");
        }

        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}