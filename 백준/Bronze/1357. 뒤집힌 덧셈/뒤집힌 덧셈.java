import java.util.*;

public class Main {
	public static int Rev(int num) { // 뒤집힌 숫자 알고리즘
		int rev = 0;
		while (num > 9) {
			rev = rev * 10 + num % 10;
			num /= 10;
		}
		return rev * 10 + num;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int X = scan.nextInt();
		int Y = scan.nextInt();

		// X,Y의 범위는 1000 이하의 자연수
		if (X < 0 || X > 1000 || Y < 0 || Y > 1000)
			System.exit(0);

		// Rev(Rev(x)+Rev(Y)) 계산
		System.out.println(Rev(Rev(X) + Rev(Y)));

		scan.close();
	}
}