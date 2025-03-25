import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(num);
        int start = 0, end = n-1, count = 0;
        while (start != end) {
            if(num[start] + num[end] <= m) {
                count += num[start] + num[end] == m ? 1 : 0;
                start++;
                continue;
            }
            end--;
        }

        System.out.println(count);
    }
}
