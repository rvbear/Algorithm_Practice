import java.util.*;

public class Solution {
    static int N, div, result;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            board = new char[N][N];
            result = 0;
            
            if (N == 1) {
                result = sc.nextInt();
            } else {
                for (int i = 0; i < N; i++) {
                    board[i] = sc.next().toCharArray();
                }
                
                div = N / 2;
                boolean change = true;
                
                for (int i = 0; i < N; i++) {
                    for (int j = div; j < N - div; j++) {
                        result += board[i][j] - '0';
                    }
                    
                    if (change) {
                        div--;
                        change = div != 0;
                    } else {
                        div++;
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
