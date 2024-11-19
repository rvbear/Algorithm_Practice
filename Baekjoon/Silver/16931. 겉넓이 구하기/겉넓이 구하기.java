import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());          // 가로
        int m = Integer.parseInt(stk.nextToken());          // 세로
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int result = n*m*2;                                 // 전체 위, 아래면을 더해줌
        for(int i = 0; i < n; i++) {                        // 행의 가장자리를 다 더해줌
            result += arr[i][0];
            result += arr[i][m-1];
        }
        for(int i = 0; i < m; i++) {                        // 열의 가장자리를 다 더해줌
            result += arr[0][i];
            result += arr[n-1][i];
        }
        for(int i = 0; i < n; i++) {                        // 행끼리 비교하여 예외가 발생한 부분을 더해줌
            for(int j = 0; j < m; j++) {
                if(i < n-1) {
                    if(arr[i][j] < arr[i+1][j]) {
                        result += arr[i+1][j] - arr[i][j];
                    }
                }
                if(i > 0) {
                    if(arr[i][j] < arr[i-1][j]) {
                        result += arr[i-1][j] - arr[i][j];
                    }
                }
            }
        }
        for(int j = 0; j < m; j++) {                        // 열끼리 비교하여 예외가 발생한 부분을 더해줌
            for(int i = 0; i < n; i++) {
                if(j < m-1) {
                    if(arr[i][j] < arr[i][j+1]) {
                        result += arr[i][j+1] - arr[i][j];
                    }
                }
                if(j > 0) {
                    if(arr[i][j] < arr[i][j-1]) {
                        result += arr[i][j-1] - arr[i][j];
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        br.close(); bw.close();
    }
}