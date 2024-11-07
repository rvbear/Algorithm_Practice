import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] parent, time;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        time[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(now == k) return;

            for(int i = 0; i < 3; i++) {
                int next = now;

                if(i == 0) {
                    next += 1;
                } else if(i == 1) {
                    next -= 1;
                } else {
                    next *= 2;
                }

                if(next < 0 || next > 100000) continue;

                if(time[next] == 0) {
                    q.offer(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        parent = new int[100001];
        time = new int[100001];

        bfs();

        Stack<Integer> s = new Stack<>();
        s.push(k);
        int index = k;

        while(index != n) {
            s.push(parent[index]);
            index = parent[index];
        }

        while(!s.isEmpty()) {
            stb.append(s.pop()).append(" ");
        }

        bw.write(time[k]-1 + "\n");
        bw.write(stb.toString());
        
        br.close();
        bw.close();
    }
}