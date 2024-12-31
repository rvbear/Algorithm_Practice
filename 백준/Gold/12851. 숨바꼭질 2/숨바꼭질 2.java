import java.io.*;
import java.util.*;

public class Main {
    static int n, k, min, count;
    static int[] time;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        time[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(min < time[now]) return;

            for(int i = 0; i < 3; i++) {
                int next = 0;

                if(i == 0) {
                    next = now + 1;
                } else if(i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if(next < 0 || next > 100000) continue;

                if(next == k) {
                    min = time[now];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[now] + 1) {
                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        min = Integer.MAX_VALUE;
        count = 0;
        time = new int[100001];

        if(n >= k) {
            System.out.println((n-k) + "\n1");
            return;
        }
        
        bfs();

        System.out.println(min + "\n" + count);
        br.close();
    }
}