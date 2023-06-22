import java.io.*;
import java.util.*;

class Node {                // class
    int num, start, finish;
    public Node(int num, int start, int finish) {
        this.num = num;
        this.start = start;
        this.finish = finish;
    }
}

public class Main {
    public static List<Node> list = new ArrayList<>();                      // Node 담을 배열
    public static PriorityQueue<Integer> que = new PriorityQueue<>();       // 우선순위 큐
    public static Comparator<Node> comparator = new Comparator<Node>() {    // 시작 시간이 빠른 순서대로 정렬
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.start, o2.start);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력

        int N = Integer.parseInt(br.readLine());        // 강의 개수 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stk.nextToken());
            int start = Integer.parseInt(stk.nextToken());
            int finish = Integer.parseInt(stk.nextToken());

            list.add(new Node(num, start, finish));
        }

        Collections.sort(list, comparator);         // 시작 시간이 빠른 순서대로 정렬

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N ; i++) {
            while(!que.isEmpty() && que.peek() <= list.get(i).start)    // que에 값이 있으면서 가장 맨 위값이 시작시간보다 빠를 경우
                que.poll();                                             // que에서 값을 제외
            que.add(list.get(i).finish);                                // 해당 node의 finish 값을 que에 저장
            max = Math.max(max, que.size());                            // 가장 최대의 que 사이즈가 정답
        }

        System.out.println(max);
        br.close();         // 입력 버퍼 스트림 닫아줌
    }
}