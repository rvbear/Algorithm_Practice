import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max;
    static boolean[] visited;
    static int[] arr;
    static List<List<Integer>> map;

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int vertex = now[0];
            int len = now[1];

            max = Math.max(max, len);
            arr[vertex] = len;

            for(int i = 0; i < map.get(vertex).size(); i++) {
                int nVertex = map.get(vertex).get(i);

                if(visited[nVertex]) continue;

                q.offer(new int[]{nVertex, len + 1});
                visited[nVertex] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new ArrayList<>();
        visited = new boolean[n+1];
        arr = new int[n+1];
        max = Integer.MIN_VALUE;

        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map.get(a).add(b);
            map.get(b).add(a);
        }

        bfs();

        int maxIndex = 0, maxCount = 0;
        for(int i = 1; i <= n; i++) {
            if(arr[i] == max) {
                if(maxIndex == 0) {
                    maxIndex = i;
                }
                maxCount++;
            }
        }

        System.out.println(maxIndex + " " + max + " " + maxCount);
        br.close();
    }
}