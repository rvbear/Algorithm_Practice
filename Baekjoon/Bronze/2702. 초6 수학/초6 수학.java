import java.util.*;

public class Main {
	public void Solution(int a, int b) {
		int min = (a > b) ? b : a;
		int gcd = 0;
		for (int i = 1; i <= min; i++) {
			if (a % i == 0 && b % i == 0)
				gcd = i;
		}

		System.out.print(a * b / gcd + " "); // 유클리드 호제법 : 두 수를 곱한 걸 최대공약수로 나누면 최소공배수가 된다
		System.out.println(gcd);
	}

	public Main() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> num = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			int number1 = scan.nextInt();
			int number2 = scan.nextInt();
			num.add(number1);
			num.add(number2);
		}

		for (int i = 0; i < N * 2; i += 2) {
			int a = num.get(i);
			int b = num.get(i + 1);
			Solution(a, b);
		}
		scan.close();
	}

	public static void main(String[] args) {
		new Main();
	}
}