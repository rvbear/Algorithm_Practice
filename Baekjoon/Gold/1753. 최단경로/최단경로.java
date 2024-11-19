import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100000000;
    static int V, E, K;
    static List<int[]>[] list;
    static int[] dist;

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[V+1];
        pq.offer(new int[] {K, 0});
        dist[K] = 0;

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            int now = temp[0];

            if(visited[now]) continue;
            visited[now] = true;

            for(int[] arr : list[now]) {
                if(dist[arr[0]] > dist[now] + arr[1]) {
                    dist[arr[0]] = dist[now] + arr[1];
                    pq.offer(new int[] {arr[0], dist[arr[0]]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        dist = new int[V+1];

        Arrays.fill(dist, INF);
        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            list[u].add(new int[]{v, w});
        }

        dijkstra();

        for(int i = 1; i <= V; i++) {
            if(dist[i] == INF) {
                stb.append("INF\n");
            } else {
                stb.append(dist[i]).append("\n");
            }
        }

        bw.write(stb.toString());
        br.close();
        bw.close();
    }
}