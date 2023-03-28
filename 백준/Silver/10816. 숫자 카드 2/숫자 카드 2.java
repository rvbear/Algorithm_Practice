import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 출력
        StringBuilder stb = new StringBuilder();            // StringBuilder를 사용해 출력

        int N = Integer.parseInt(br.readLine());                    // 상근이가 가지고 있는 카드의 개수
        HashMap<Integer, Integer> map = new HashMap<>();            // HashMap을 사용
        StringTokenizer stk = new StringTokenizer(br.readLine());   // StringTokenizer를 사용하여 분해
        for(int i = 0; i < N; i++) {
            int card = Integer.parseInt(stk.nextToken());
            if(map.containsKey(card) == false)
                map.put(card, 1);
            else
                map.put(card, map.get(card) + 1);
        }

        int M = Integer.parseInt(br.readLine());                    // 상근이가 몇개 가지고 있는지 구해야할 카드의 개수
        stk = new StringTokenizer(br.readLine());                   // StringTokenizer를 사용해 분해
        for(int j = 0; j < M; j++) {                                // M번 반복
            int find = Integer.parseInt(stk.nextToken());
            if (map.containsKey(find) == true)                      // 상근이가 카드를 가지고 있다면
                stb.append(map.get(find)).append(" ");              // 가지고 있는 개수와 공백을 StringBuilder에 저장
            else                                                    // 카드를 가지고 있지 않다면
                stb.append(0).append(" ");                          // 0과 공백을 StringBuilder에 저장
        }

        System.out.println(stb);            // StringBuilder에 저장된 값을 출력
        br.close();                         // 입력 버퍼 스트림 닫아줌
    }
}