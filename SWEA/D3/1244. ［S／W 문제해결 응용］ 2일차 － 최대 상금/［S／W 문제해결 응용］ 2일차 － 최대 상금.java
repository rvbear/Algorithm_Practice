import java.util.Scanner;

public class Solution {
    static char[] nums;
    static int changes;
    static int result;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            nums = sc.next().toCharArray();
            changes = sc.nextInt();
            result = 0;

            dfs(0, 0);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int pos, int count) {
        if (count == changes) {
            int val = Integer.parseInt(new String(nums));
            result = Math.max(result, val);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                swap(i, j);
                dfs(i, count + 1);
                swap(i, j);
            }
        }
    }

    private static void swap(int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
