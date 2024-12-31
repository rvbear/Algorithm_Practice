import java.io.*;
import java.util.*;

public class Main {
    static int n, k, minTime;
    static boolean[] visited;

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {n, 0});

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int now = temp[0];
            int time = temp[1];
            visited[now] = true;

            if(now == k) {
                minTime = Math.min(time, minTime);
            }

            if(now * 2 < 100001 && !visited[now * 2]) {
                q.offer(new int[] {now * 2, time});
            }
            if(now + 1 < 100001 && !visited[now + 1]) {
                q.offer(new int[] {now + 1, time + 1});
            }
            if(now - 1 >= 0 && !visited[now - 1]) {
                q.offer(new int[] {now - 1, time + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        minTime = Integer.MAX_VALUE;
        visited = new boolean[100001];

        bfs();

        System.out.println(minTime);
        br.close();
    }
}