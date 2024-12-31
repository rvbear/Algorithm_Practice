import java.util.*;

public class Main {
	public static int compare(int a, int b, int c) {
		if (a >= b) {
			if (b >= c)
				return c;
			else
				return b;
		} else {
			if (a >= c)
				return c;
			return a;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int Mw = scanner.nextInt();
		int Mb = scanner.nextInt();
		int Tw = scanner.nextInt();
		int Tb = scanner.nextInt();
		int Pw = scanner.nextInt();
		int Pb = scanner.nextInt();

		if ((0 > Mw && Mw > 1000000000) || (0 > Mb && Mb > 1000000000) || (0 > Tw && Tw > 1000000000)
				|| (0 > Tb && Tb > 1000000000) || (0 > Pw && Pw > 1000000000) || (0 > Pb && Pb > 1000000000)) {
			System.out.println("범위를 벗어났습니다.");
			return;
		}

		int min1 = compare(Mw, Tb, Pw);
		int min2 = compare(Mb, Tw, Pb);

		if (min1 > min2)
			System.out.println(2 * min2 + 1);
		else if (min1 == min2)
			System.out.println(2 * min1);
		else
			System.out.println(2 * min1 + 1);

		scanner.close();
	}
}