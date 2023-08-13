import java.io.*;
import java.util.*;

class Point {           // 좌표 클래스
    int x, y;

    public Point(int _x, int _y) {
        x = _x; y = _y;
    }
}
public class Main {
    // 맨해튼 거리 구하기 메서드
    public static int Manhattan(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    // BFS 탐색 메서드
    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visit = new boolean[n+2];
        visit[0] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == n+1) {
                return true;
            }

            for(int next : graph.get(now)) {
                if(!visit[next]) {
                    visit[next] = true;
                    queue.offer(next);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        ArrayList<Point> point;                 // 집, 편의점, 페스티벌의 x, y 좌표를 저장할 배열
        ArrayList<ArrayList<Integer>> graph;
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            point = new ArrayList<>();
            for(int j = 0; j < n+2; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                point.add(new Point(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())));
            }

            graph = new ArrayList<>();
            for(int j = 0; j < n+2; j++) {
                graph.add(new ArrayList<>());
            }

            // 맨해튼 거리 1000m 이하를 만족하는 두 정점을 찾은 뒤
            // 양방향 그래프로 서로 이어줌
            for(int a = 0; a < n+2; a++) {
                for(int b = a+1; b < n+2; b++) {
                    if(Manhattan(point.get(a), point.get(b)) <= 1000) {
                        graph.get(a).add(b);
                        graph.get(b).add(a);
                    }
                }
            }

            bw.write((bfs(graph, n) ? "happy" : "sad") + "\n");       // BFS 탐색을 통해 가능, 불가능 여부 판단 후 출력
        }

        br.close(); bw.close();
    }
}