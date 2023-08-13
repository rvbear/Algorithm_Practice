import java.io.*;
import java.util.*;

class Point {           // 좌표 클래스
    int x, y;

    public Point(int _x, int _y) {
        x = _x; y = _y;
    }
}
public class Main {
    static int n;                   // 매점의 개수
    static Point[] store;           // 매점의 좌표를 저장할 배열
    static boolean[] visit;         // 매점 방문 여부를 확인할 배열
    // 맨해튼 거리 구하기 메서드
    public static int Manhattan(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    // BFS 탐색 메서드
    public static boolean bfs(Point home, Point festival) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(home);

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(Manhattan(now, festival) <= 1000) {          // 맨해튼 거리 1000m 안에 있으면 갈 수 있음
                return true;
            }

            for(int i = 0; i < n; i++) {                    // 갈 수 없다면 다른 매점을 들려서 가야함
                if(!visit[i] && Manhattan(now, store[i]) <= 1000) {
                    queue.offer(store[i]);
                    visit[i] = true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int t = Integer.parseInt(br.readLine());            // 테스트 케이스 개수
        
        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            // 집의 좌표 저장
            Point home = new Point(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()));
            store = new Point[n];                           
            visit = new boolean[n];                          
            for(int j = 0; j < n; j++) {                    // 매점의 좌표를 저장
                stk = new StringTokenizer(br.readLine());
                store[j] = new Point(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()));
            }
            stk = new StringTokenizer(br.readLine());
            // 페스티벌의 좌표 저장
            Point festival = new Point(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()));

            bw.write((bfs(home, festival) ? "happy" : "sad") + "\n");       // BFS 탐색을 통해 가능, 불가능 여부 판단 후 출력
        }

        br.close(); bw.close();
    }
}