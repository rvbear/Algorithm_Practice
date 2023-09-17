import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] building;
    static int[] arr;
    public static long check(int i, int j, int k) {
        return (long)i*building[k] + (long)j*building[i] + (long)k*building[j] - ((long)i*building[j] + (long)j*building[k] + (long)k*building[i]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        building = new long[n];
        arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            building[i] = Long.parseLong(stk.nextToken());
        }

        boolean flag = false;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                flag = true;
                for(int k = i+1; k < j; k++) {
                    if(check(i, j, k) <= 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    arr[i]++;
                    arr[j]++;
                }
            }
        }

        int result = 0;
        for(int a : arr) {
            result = Math.max(result, a);
        }
        System.out.println(result);
        br.close();
    }
}