import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());                // 펼쳐진 카드의 개수
        HashMap<String, Integer> hashMap = new HashMap<>();     // 값을 확인할 hashmap

        for(int i = 0; i < N; i++) {                            // N만큼 반복
            stk = new StringTokenizer(br.readLine());
            String fruit = stk.nextToken();
            int num = Integer.parseInt(stk.nextToken());
            if(!hashMap.containsKey(fruit))                     // hashmap에 값이 없다면 값을 넣어줌
                hashMap.put(fruit, num);
            else                                                // hashmap에 값이 있다면 이전 값에 num값을 더한 뒤 저장
                hashMap.put(fruit, hashMap.get(fruit) + num);
        }

        for(String key : hashMap.keySet())                      // hashmap을 탐색하면서 value가 5라면 Yes 출력 후 종료
            if(hashMap.get(key) == 5) {
                System.out.println("YES");
                return;
            }

        System.out.println("NO");                               // 아니라면 NO 출력
        br.close();     // 입력 버퍼 스트림 닫아줌
    }
}