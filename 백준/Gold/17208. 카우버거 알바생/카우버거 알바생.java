import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, K;
    static int[][] order;
    static int[][][] dp;

    static int knapsack(int index, int b, int f) {
        if(index == N) {
            return 0;
        }

        int burger = order[index][0];
        int fri = order[index][1];

        if(dp[index][b][f] != 0) {
            return dp[index][b][f];
        }

        int count = knapsack(index+1, b, f);

        if(burger <= b && fri <= f) {
            count = Math.max(knapsack(index+1, b-burger, f-fri) + 1, count);
        }

        return dp[index][b][f] = count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        K = Integer.parseInt(data[2]);
        order = new int[N][2];
        dp = new int[N][301][301];

        for(int i = 0; i < N; i++) {
            String[] orderInfo = br.readLine().split(" ");
            order[i][0] = Integer.parseInt(orderInfo[0]);
            order[i][1] = Integer.parseInt(orderInfo[1]);
        }

        System.out.println(knapsack(0, M, K));
        br.close();
    }
}
