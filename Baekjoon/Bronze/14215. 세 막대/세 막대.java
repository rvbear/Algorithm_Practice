import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        int temp = arr[0] + arr[1];
        if(temp > arr[2]) {
            System.out.println(temp + arr[2]);
        } else {
            System.out.println(temp + temp - 1);
        }
        br.close();
    }
}