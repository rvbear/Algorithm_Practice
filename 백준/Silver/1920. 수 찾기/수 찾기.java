import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Long> map = new HashMap<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            long num = Long.parseLong(stk.nextToken());
            map.put(num, num);
        }

        int m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            bw.write(String.valueOf(map.containsKey(Long.parseLong(stk.nextToken())) ? 1 : 0) + "\n");
        }
        br.close();
        bw.close();
    }
}