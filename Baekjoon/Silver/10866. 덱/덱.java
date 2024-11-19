import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String order = stk.nextToken();
            if(stk.hasMoreTokens()) {
                int num = Integer.parseInt(stk.nextToken());
                if(order.equals("push_back")) {
                    d.addLast(num);
                } else {
                    d.addFirst(num);
                }
            } else if(order.equals("pop_front")) {
                bw.write(String.valueOf(!d.isEmpty() ? d.removeFirst() : -1) + "\n");
            } else if(order.equals("pop_back")) {
                bw.write(String.valueOf(!d.isEmpty() ? d.removeLast() : -1) + "\n");
            } else if(order.equals("size")) {
                bw.write(String.valueOf(d.size()) + "\n");
            } else if(order.equals("empty")) {
                bw.write(String.valueOf(!d.isEmpty() ? 0 : 1) + "\n");
            } else if(order.equals("front")) {
                bw.write(String.valueOf(!d.isEmpty() ? d.peekFirst() : -1) + "\n");
            } else if(order.equals("back")) {
                bw.write(String.valueOf(!d.isEmpty() ? d.peekLast() : -1) + "\n");
            }
        }

        br.close(); bw.close();
    }
}