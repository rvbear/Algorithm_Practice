import java.util.*;

public class Solution {
    static int[] boxes;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int dumpCount = sc.nextInt();
            boxes = new int[100];

            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }

            while (dumpCount-- > 0) {
                Arrays.sort(boxes);
                boxes[0]++;
                boxes[99]--;
            }
            
            Arrays.sort(boxes);
            
            System.out.println("#" + t + " " + (boxes[99] - boxes[0]));
        }
    }
}
