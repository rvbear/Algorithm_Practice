import java.util.*;

public class Solution {
    static int[][] map;
    static int[] row, col;
    static int lCross, rCross, caseNum, val, result;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            caseNum = sc.nextInt();

            map = new int[100][100];
            row = new int[100];
            col = new int[100];
            result = lCross = rCross = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    val = sc.nextInt();

                    row[i] += val;
                    col[j] += val;

                    if (i == j) {
                        lCross += val;
                    }

                    if (i + j == 99) {
                        rCross += val;
                    }
                }
                
                result = Math.max(result, row[i]);
            }
            
            for (int i = 0; i < 100; i++) {
                result = Math.max(result, col[i]);
            }

            System.out.println("#" + caseNum + " " + Math.max(result, Math.max(lCross, rCross)));
        }
    }
}
