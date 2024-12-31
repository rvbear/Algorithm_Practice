import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력

        StringTokenizer stk = new StringTokenizer(br.readLine());               // StringTokenizer를 사용해 분해
        int N = Integer.parseInt(stk.nextToken());                              // 큐의 크기 입력
        int M = Integer.parseInt(stk.nextToken());                              // 뽑아낼 수의 개수 입력

        Deque<Integer> deque = new LinkedList<>();                              // Deque 선언
        for(int i = 1; i <= N; i++)                                             // Deque에 값을 넣어줌
            deque.add(i);

        stk = new StringTokenizer(br.readLine());
        int count = 0, r_cnt = 1, l_cnt = 0;                    // 총 움직인 횟수, 왼쪽으로 움직인 횟수, 오른쪽으로 움직인 횟수
        for(int i = 0; i < M; i++) {
            int pop = Integer.parseInt(stk.nextToken());
            Iterator<Integer> left = deque.iterator();          // 정방향으로 값들을 불러옴
            while(left.hasNext()){                              // 값을 확인해서 뽑아내려는 값과 같다면 break, 다르다면 움직여줌
                int val1 = left.next();
                if(val1 == pop) break;
                l_cnt++;
            }
            Iterator<Integer> right = deque.descendingIterator();   // 역방향으로 값들을 불러옴
            while(right.hasNext()) {                                // 동일하게 확인하여 같다면 break, 다르다면 움직여줌
                int val2 = right.next();
                if(val2 == pop) break;
                r_cnt++;
            }
            count += r_cnt > l_cnt ? l_cnt : r_cnt;             // 왼쪽으로 움직인 횟수가 적다면 l_cnt, 아니라면 r_cnt를 count에 더해줌
            if(r_cnt > l_cnt)                                   // l_cnt가 작다면 왼쪽으로 값을 움직여줌
                for(int j = 0; j < l_cnt; j++)
                    deque.addLast(deque.removeFirst());
            else                                                // r_cnt가 작다면 오른쪽으로 값을 움직여줌
                for (int j = 0; j < r_cnt; j++)
                    deque.addFirst(deque.removeLast());
            deque.pop();                                        // 값을 뽑아냄
            r_cnt = 1; l_cnt = 0;                               // 왼쪽, 오른쪽 카운트 초기화
        }

        System.out.println(count);                              // 총 움직인 횟수 출력
        br.close();                                             // 입력 버퍼 스트림 닫아줌
    }
}