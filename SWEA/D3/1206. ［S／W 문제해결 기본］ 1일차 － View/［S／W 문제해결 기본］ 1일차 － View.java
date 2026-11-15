import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
            int[] buildings = new int[N];

            for (int i = 0; i < N; i++) {
                buildings[i] = sc.nextInt();
            }

            int answer = 0;

            for (int j = 2; j < N - 2; j++) {
                int leftMax = Math.max(buildings[j - 2], buildings[j - 1]);
                int rightMax = Math.max(buildings[j + 1], buildings[j + 2]);
                int max = Math.max(leftMax, rightMax);

                if (buildings[j] > max) {
                    answer += buildings[j] - max;
                }
            }

            System.out.println("#" + testCase + " " + answer);
		}
	}
}
