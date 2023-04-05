import java.util.*;

public class Main {
	static int arr[] = new int[10];
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String N = scanner.nextLine();
		int[] num = new int[N.length()];

		for (int i = 0; i < N.length(); i++)
			num[i] = N.charAt(i) - '0';

		for (int i = 0; i < N.length(); i++) {
			if (arr[num[i]] == 0) {
				if (num[i] == 6 && arr[9] != 0) {
					arr[9] -= 1;
					continue;
				} else if (num[i] == 9 && arr[6] != 0) {
					arr[6] -= 1;
					continue;
				} else {
					for (int j = 0; j < 10; j++)
						arr[j] += 1;
					cnt++;
					arr[num[i]] -= 1;
				}
			} else
				arr[num[i]] -= 1;
		}

		System.out.println(cnt);

		scanner.close();
	}
}