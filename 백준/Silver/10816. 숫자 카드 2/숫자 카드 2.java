import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력

        int N = Integer.parseInt(br.readLine());                    // 상근이가 가지고 있는 카드의 개수
        HashMap<Integer, Integer> map = new HashMap<>();            // HashMap을 사용
        StringTokenizer stk = new StringTokenizer(br.readLine());   // StringTokenizer를 사용하여 분해
        for(int i = 0; i < N; i++) {
            int card = Integer.parseInt(stk.nextToken());
            if(!map.containsKey(card))                              // 값이 존재하지 않는다면
                map.put(card, 1);                                   // value에 1을 저장
            else                                                    // 값이 존재한다면
                map.put(card, map.get(card) + 1);                   // 원래 value값에 1을 더한 값을 저장
        }

        int M = Integer.parseInt(br.readLine());                    // 상근이가 몇개 가지고 있는지 구해야할 카드의 개수
        stk = new StringTokenizer(br.readLine());                   // StringTokenizer를 사용해 분해
        for(int j = 0; j < M; j++) {                                // M번 반복
            int find = Integer.parseInt(stk.nextToken());
            if (map.containsKey(find))                      // 상근이가 카드를 가지고 있다면
                bw.write(String.valueOf(map.get(find)) + " ");
            else                                                    // 카드를 가지고 있지 않다면
                bw.write(0 + " ");
        }

        br.close();                         // 입력 버퍼 스트림 닫아줌
        bw.close();                         // 출력 버퍼 스트림 닫아줌
    }
}