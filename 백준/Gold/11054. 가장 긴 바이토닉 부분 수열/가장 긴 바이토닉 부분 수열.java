import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, upDp, downDp;

    static void createUp() {
        upDp = new int[n];
        for (int i = 0; i < n; i++) {
            upDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    upDp[i] = Math.max(upDp[i], upDp[j] + 1);
                }
            }
        }
    }

    static void createDown() {
        downDp = new int[n];
        for (int i = n - 1; i > -1; i--) {
            downDp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    downDp[i] = Math.max(downDp[i], downDp[j] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        createUp();
        createDown();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, upDp[i] + downDp[i]);
        }

        System.out.println(max - 1);
    }
}
